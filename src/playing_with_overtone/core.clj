(ns playing-with-overtone.core
  (:require [overtone.live :refer :all])
  (:require [overtone.studio.scope :refer :all]))

(scope)
(ding)
(definst super-simple-synth [freqency 440]
  (sin-osc freqency))


(super-simple-synth)
(super-simple-synth 880)
(stop)

(def beep-beep ;definied in current namespace
  (synth ; wrapped in overtone synthesizer
   (out 0 (sin-osc 440)))); plugs output of the ugen sin-osc into the output 0

(defsynth beep-beep []
  (out 0 (sin-osc 220)))

((synth
  (out 0 (sin-osc (+ 440
                   (* 440 (sin-osc 1)))))))
 ; 1 is amplitude, 440 is freqency

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(println "We are the MONSTER TONES!")

(beep-beep)
(stop)

(def kick-fat (freesound 2086))
(def snare-fat (freesound 122053))

(load-sample)
(defn loop-beat []
 )

(definst beep2 [freq 440]
  (*
   (env-gen (perc))
   (sin-osc freq)))

(scope)
(beep2)

(defn from [m beat]
;;let introduces local variables
  (fn [beat] (m (+2 beat))))

;; bpm -> (beat-nr -> time-ms)
          (       -> next-beat-nr)

(defn start-beat [m]
  (at (m 0) (kick-fat))
  (at (m 1) (snare-fat))
  (apply-by (m 2) start-beat [(from m 2)]))

;;fn = #()

(defn start-beat [m]


(stop)

(kick-fat)
(snare-fat)
