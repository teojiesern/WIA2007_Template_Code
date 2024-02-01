Some key things to keep in mind:

Don’t go and think whether this shit is in internal or external, it just makes life worse and
contribute to nothing at all

# App specific storage

No permission required, mainly using file reads and no need to say which storage to use i.e.
external or internal, it seems that we can straight away create a file output stream and write
things using byte characters, no need any explicitly saying of which directory which folder things
like that, by default writing form an app will go into the app specific storage I assume, can have a
look in device explorer → data → data → appName → files

# Shared Storage

For this, normally would need some permissions granted like readMedia permission things like that,
we can use contentResolver to query media images from the emulator with prerequisite that the
emulator must have some media files in store. Can have a look in device explorer → storage →
emulated → 0 → Downloads, for some reason the photos are kept there but not gonna question shit

# Shared Preferences

This is the easiest to work with, just define the sharedpreference which is very easy to get, and
can start getting key value pairs and writing to it as well, can have a look at device explorer →
data → data → appName → sharedPreference
