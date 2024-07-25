$BuildDirectory = "dist"
$BuildZip = "$BuildDirectory\Goofycraft.zip"
$InstallZip = "C:\Users\strin\AppData\Roaming\.minecraft\resourcepacks\Goofycraft.zip"

.\build.ps1

Copy-Item -Path $BuildZip -Destination $InstallZip -Force
