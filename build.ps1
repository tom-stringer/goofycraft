New-Item -Path dist -ItemType Directory -Force
&"C:\Program Files\7-Zip\7z.exe" a -tzip -y .\dist\Goofycraft.zip .\src\*