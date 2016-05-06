(ns js-to-edn.core
  (:require [cljs.nodejs :as nodejs]
            [cognitect.transit :as t]
            [clojure.walk :as w]
            [clojure.string :as s]
            [cljs.pprint :as p]))

(nodejs/enable-util-print!)

(def json-reader (t/reader :json))


(defn wrap-to-obj [text]
  (if-not (or (and (s/starts-with? text "{")
                   (s/ends-with? text "}"))
              (and (s/starts-with? text "[")
                   (s/ends-with? text "]")))
    (str "{" text "}")
    text))

(defn -main [& args]
  (let [text (-> (aget nodejs/process "argv")
                 (nth 2)
                 s/trim
                 wrap-to-obj)]
    (p/pprint (->> (str "JSON.stringify(" text ")")
                   js/eval
                   (t/read json-reader)
                   w/keywordize-keys))))

(set! *main-cli-fn* -main)

