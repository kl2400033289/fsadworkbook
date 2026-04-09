$ErrorActionPreference = 'Stop'

$root = Split-Path -Parent $MyInvocation.MyCommand.Path
$frontendPath = Join-Path $root 'frontend'
$backendPath = Join-Path $root 'backend'
$staticPath = Join-Path $backendPath 'src/main/resources/static'

Write-Host '1) Building React production bundle...'
Set-Location $frontendPath
npm install
npm run build

Write-Host '2) Copying frontend build to Spring static folder...'
if (Test-Path $staticPath) {
  Remove-Item -Recurse -Force (Join-Path $staticPath '*') -ErrorAction SilentlyContinue
} else {
  New-Item -ItemType Directory -Path $staticPath | Out-Null
}
Copy-Item -Recurse -Force (Join-Path $frontendPath 'dist/*') $staticPath

Write-Host '3) Packaging Spring Boot backend JAR...'
Set-Location $backendPath
if (Get-Command mvn -ErrorAction SilentlyContinue) {
  mvn clean package -DskipTests
} else {
  Write-Warning 'Maven command not found in terminal PATH. Package backend from STS using Maven Build with goals: clean package -DskipTests.'
}

Write-Host 'Deployment preparation completed.'
