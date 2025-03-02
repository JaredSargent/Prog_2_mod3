// Program: User Interface Example
// Purpose: Create a GUI with a menu to display date/time, write to file, change background to random orange, and exit

DEFINE a window (frame) with title "User Interface Example"
SET frame size to 400x300 pixels
SET frame to close on exit

CREATE a menu bar
CREATE a menu called "Options"
CREATE menu items:
    item1: "Display Date and Time"
    item2: "Write to File"
    item3: "Change Background Color"
    item4: "Exit"
ADD menu items to "Options" menu
ADD "Options" menu to menu bar
ATTACH menu bar to frame

CREATE a text area (textArea) for displaying output
SET textArea to read-only
SET textArea to transparent (non-opaque)
WRAP textArea in a scrollable pane (scrollPane)
SET scrollPane and its viewport to transparent
ADD scrollPane to frame's center

DEFINE FUNCTION for "Display Date and Time" (item1):
    GET current date and time
    FORMAT date and time as "yyyy-MM-dd HH:mm:ss"
    SET textArea content to "Current Date and Time: [formatted date/time]"

DEFINE FUNCTION for "Write to File" (item2):
    TRY
