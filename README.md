# HeldenHerzen

Paper-Plugin für Minecraft 1.20.1.

## Befehle

- `/helden herz 1` -> gibt „Helden Herz 1“
- `/helden herz 2` -> gibt „Helden Herz 2“

Der Item selbst nutzt `Material.PAPER` mit `CustomModelData` und ist damit für ein passendes Resourcepack vorbereitbar. Ohne Resourcepack sieht er wie ein normales Papier-Item aus. Für die exakte Darstellung mit den 3 blauen Herzen und dem schwarzen Fragezeichen brauchst du zusätzlich ein passendes Resourcepack.

## Bauen

`mvn package`

Danach die JAR-Datei aus `target/` in den `plugins`-Ordner des Paper-Servers kopieren und den Server starten.
