# js-to-edn

Simple command line utility to convert Javascript data structure (map or array) or JSON to pretty EDN.
Useful when copying pasting JS snippets from web.

## Usage
```
lein cljsbuild once

node release/js_to_edn.js  "{container: { flex: 1, flexDirection: 'row', justifyContent: 'center', alignItems: 'center', backgroundColor: '#F5FCFF'}}  "{container: { flex: 1, flexDirection: 'row', justifyContent: 'center', alignItems: 'center', backgroundColor: '#F5FCFF'}}"
                            
{:container
 {:flex 1,
  :flexDirection "row",
  :justifyContent "center",
  :alignItems "center", 
  :backgroundColor "#F5FCFF"}}
  
  
node release/js_to_edn.js "something : {something:  'else'}"

{:something {:something "else"}}

```

## License

Copyright © 2015 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at your option) any later version.
