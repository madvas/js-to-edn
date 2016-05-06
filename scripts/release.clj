(require '[cljs.build.api :as b])

(println "Building ...")

(let [start (System/nanoTime)]
  (b/build "src"
           {:output-to     "release/js_to_edn.js"
            :output-dir    "release"
            :optimizations :advanced
            :target        :nodejs
            :verbose       true
            :pretty-print  true})
  (println "... done. Elapsed" (/ (- (System/nanoTime) start) 1e9) "seconds"))
