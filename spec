### war of the wilderlands spec 2d map turned based strategy

spring boot backend
spring boot backend main engine and main loop and state storage
map generate in /map endpoint return binay byte array octect stream 10 x 10 map

0 1 2 0 1 2 0 1 2 0
1 2 0 1 2 0 1 2 0 1
2 0 1 2 0 1 2 0 1 2
0 1 2 0 1 2 0 1 2 0
1 2 0 1 2 0 1 2 0 1
2 0 1 2 0 1 2 0 1 2
0 1 2 0 1 2 0 1 2 0
1 2 0 1 2 0 1 2 0 1
2 0 1 2 0 1 2 0 1 2
0 1 2 0 1 2 0 1 2 0

map store in src main resource wars-map.txt

vue and pixi js and vite frontend. At startup of vu app it shall ask /map endpoint for a this map and render it
in the web browswer

npm create vite@latest wars-app --template vue
cd wars-app
npm install
npm run dev

