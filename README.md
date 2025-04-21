[![Alura + Oracle ONE](https://app.aluracursos.com/form-one/assets/images/logo-aluralatam-oracle.svg)](https://aluracursos.com)

<sub>Java Orientado a Objetos G8 - ONE </sub><br> 
Challenge: <ins>CONVERSOR DE DIVISAS</ins>

# ExchangeRate-API Client

<sup>Command-line client for interacting with the ExchangeRate-API service.</sup><br>
Cliente de línea de comandos para interactuar con el servicio de ExchangeRate-API.

## <sub>Features</sub><br>Características
![img](https://img.shields.io/badge/interface-CLI-blue)
![img](https://img.shields.io/badge/config.-config.xml-blue)
![img](https://img.shields.io/badge/multilanguaje-es,_pt,_en-blue)

## <sub>Screenshot</sub><br>Pantalla de ayuda
```
usage:
                     exchangerate --help
                     exchangerate --list
                     exchangerate --from COD [--to COD [--amount N]]

 -a,--amount <arg>   quantia a ser convertida
 -f,--from <arg>     código da moeda base (ISO 4217)
 -h,--help           exibir as opções disponíveis
 -l,--list           listar todas as moedas suportadas
 -t,--to <arg>       código da moeda de destino (ISO 4217)

Sjlvanq, Ⓒ 2025
```


## <sub>Setup</sub><br>Configuración
* Renombrar `config.example.xml` a `config.xml`
* Buscar dentro del archivo la entrada con clave `api.key` y reemplazar el texto `YOUR-API-KEY` por la clave que has obtenido al crear una cuenta en https://exchangerate-api.com


```shell
./compile.sh
```

```shell
./run.sh --help
```
