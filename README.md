
# :iphone: App: Convierte texto a voz:sound:

Convierte texto a voz de manera rapida y eficiente, con la ayuda de ElevenLabs.


## Pantallas
<div align="center">
  <img src="https://github.com/JmanuelJ/Resources-Myrepos/blob/main/Functions%20Speech-20240807T201426Z-001/Functions%20Speech/Main-Screen.jpg" height="250" alt="main screen"  />
  <img src="https://github.com/JmanuelJ/Resources-Myrepos/blob/main/Functions%20Speech-20240807T201426Z-001/Functions%20Speech/Second.Screen.jpg" height="250" alt="second screen"  />
</div>

## Ejemplo de jecucion 
[Video en Youtube: ](https://youtube.com/shorts/gajkLobZIeI?si=dBHOi6DP4QcyRZ6D) https://youtube.com/shorts/gajkLobZIeI?si=dBHOi6DP4QcyRZ6D

## Arquitectura 
### MVVM

## Libs
#### * Retrofit
#### * Okhttp
#### * Dagger Hilt
#### * Constraint


## Api

[ElevenLabs: ](https://elevenlabs.io/docs/api-reference/streaming) https://elevenlabs.io/docs/api-reference/streaming


### API Reference

#### Text To Speech Streaming

```http
  https://api.elevenlabs.io
  POST: /v1/text-to-speech/{voice_id}/stream
```
Header  

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
|  `xi-api-key`  | `string` | **Requerido:**. Tu API key |


Body

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
|  `text`  | `string` | **Requerido:** Texto a convertiry |


Path

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
|  `voice_id`  | `string` | **Requerido**. Modelo de voz  |


La API puede recibir mas parametros pero solo considere los obligatorios para relizar este ejemplo, para mas informacion al respecto consulta la documentacion en la pagina ofical de ElevenLabs.


## Licencia
### Free software!




