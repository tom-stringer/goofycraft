$BuildDirectory = "dist"
$BuildZip = "$BuildDirectory\Goofycraft.zip"
$7ZipExe = "C:\Program Files\7-Zip\7z.exe"

if (Test-Path $BuildDirectory) {
    Remove-Item -Path $BuildDirectory -Recurse -Force
}
New-Item -Path $BuildDirectory -ItemType Directory -Force
&$7ZipExe a -tzip -y $BuildZip .\src\pack.mcmeta .\src\assets