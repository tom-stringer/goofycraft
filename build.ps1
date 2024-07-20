New-Item -Path dist -ItemType Directory -Force
Compress-Archive -Path src\* -DestinationPath dist\Goofycraft.zip -Force