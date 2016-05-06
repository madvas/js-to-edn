(require '[cljs.build.api :as b])

(b/watch "src"
  {:main 'js-to-edn.core
   :output-to "out/js_to_edn.js"
   :output-dir "out"})
