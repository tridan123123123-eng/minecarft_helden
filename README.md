# HeldenHerzen

Paper-Plugin für Minecraft 1.20.1.

## Befehle

- `/helden herz 1` – gibt „Helden Herz 1“.
- `/helden herz 2` – gibt „Helden Herz 2“.

## Resourcepack automatisch beim Beitritt anbieten

Minecraft lädt ein Server-Resourcepack beim Beitritt herunter, nachdem der Spieler die Abfrage bestätigt. Dafür muss ein vollständiges Resourcepack-ZIP unter einer direkten HTTPS-Download-URL erreichbar sein.

1. Erstelle `HeldenHerzen.zip` aus dem Inhalt des Ordners `resourcepack/` (also `pack.mcmeta` und `assets/` müssen direkt im ZIP-Wurzelverzeichnis liegen).
2. Füge die beiden Texturen hinzu: `assets/heldenherzen/textures/item/helden_herz_1.png` und `helden_herz_2.png`. Ohne diese PNGs ist das Pack unvollständig.
3. Lade das ZIP auf einen Webspace hoch, der einen direkten Download der Datei anbietet.
4. Trage die URL in `plugins/HeldenHerzen/config.yml` ein:
   `resource-pack-url: "https://deine-domain.example/HeldenHerzen.zip"`
5. Starte den Server neu. Beim Beitritt erscheint dann die Minecraft-Abfrage zum Resourcepack.

Das Plugin kann kein ZIP selbst hosten und keine URL für dich erzeugen. Ohne eine erreichbare ZIP-URL kann Minecraft das Pack nicht automatisch herunterladen. Die Spieler müssen außerdem die Minecraft-Abfrage annehmen.

## Bauen

`mvn package`

Danach `target/HeldenHerzen.jar` in den `plugins`-Ordner des Paper-Servers kopieren und den Server starten.
