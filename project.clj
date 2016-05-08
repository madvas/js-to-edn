(defproject js-to-edn "0.1.0-SNAPSHOT"
  :description "Simple command line utility to convert Javascript data structure (map or array) or JSON to formatted EDN."
  :url "https://github.com/madvas/js-to-edn"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.8.51"]
                 [com.cognitect/transit-cljs "0.8.237"]]
  :jvm-opts ^:replace ["-Xmx1g" "-server"]
  :plugins [[lein-npm "0.6.1"]
            [lein-cljsbuild "1.1.3"]]
  :npm {:dependencies [[source-map-support "0.4.0"]]}
  :source-paths ["src" "target/classes"]
  :clean-targets ["out" "release"]
  :cljsbuild
  {:builds
   [{:compiler
                   {:output-to     "release/js_to_edn.js",
                    :output-dir    "release",
                    :target        :nodejs,
                    :optimizations :advanced,
                    :pretty-print  true,
                    :verbose       true},
     :source-paths ["src"]}]}

  :target-path "target")
