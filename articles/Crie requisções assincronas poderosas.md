Crie um código assíncrono para realizar milhares requisições de forma mais rápida, usando asyncio e aiohttp

Neste simples exemplo, iremos assumir que precisamos coletar item a item de uma API, para podermos verificar a performance entre a forma de coleta síncrona e assíncrona

```python
import asyncio
import aiohttp
import requests

BASE_URL = 'https://fakestoreapi.com/products' ## API possui 20 produtos como teste
TCP_REQUESTS_LIMIT = 30
TIMOUT_SECONDS_LIMIT = 300

## para criar uma função assincrona em python, basta usar async no inicio
async def async_example():
    async def get_url(session, item_id):
        response = await session.get(f'{BASE_URL}/{item_id}')
        return item_id, await response.json()

    # Definindo timeout para nossa sessão, sem timeout total e com 5 minutos para aguardar response
    session_timeout = aiohttp.ClientTimeout(total=None, sock_connect=TIMOUT_SECONDS_LIMIT, sock_read=TIMOUT_SECONDS_LIMIT)

    # Limite de conexões simultâneas para a sessão, por padrão o protocolo TCP suporta até 100
    connector = aiohttp.TCPConnector(limit=TCP_REQUESTS_LIMIT)  # Limita as requisições simultâneas (semaforo de requests)

    # Iniciamos a session com as configurações
    async with aiohttp.ClientSession(timeout=session_timeout, connector=connector) as session:
        lista_de_tarefas = []
        # Cria e popula a lista de tarefas, obs: não executa as tarefas
        for item_id in range(1, 21):
            # Usamos ensure_future para garantir o agendamento da tarefa pelo asyncio
            tarefa = asyncio.ensure_future(get_url(session, item_id))
            lista_de_tarefas.append(tarefa)

        # Diz para o asyncio executar as tarefas e aguardar o fim de todas
        resultados = await asyncio.gather(*lista_de_tarefas)
        print(resultados)

def sync_example():
    session = requests.Session()
    for item_id in range(1, 21):
        response = session.get(f'{BASE_URL}/{item_id}')
        print((item_id, response.json()))

if __name__ == '__main__':
    ### Assumindo um caso hipotético onde tenhamos que buscar item a item de uma API, qual seria mais eficiente?

    # Dependendo da internet, pode demorar entre 10 a 15 segundos ou até mais usando requests
    # sync_example()

    # O asyncio com aiohttp executa muito mais rapidamente comparado a requests normais
    asyncio.run(async_example())

    # Obs: a API possibilita trazer todos os produtos de uma única vez, são 20 produtos ao todo
    # print(requests.get(BASE_URL).json())

```
Usar a biblioteca requests é algo muito mais simples de formular comparado a uma estrutura assíncrona para requisições, porem caso o assunto seja velocidade e muita velocidade, como por exemplo na casa do milhar, o uso do conjunto de asyncio e aiohttp vale muito a pena e pode auxiliar neste processo


Obs:
Vale ressaltar que a biblioteca requests do python se comporta de forma sincrona, mesmo que utilizada dentro de uma função async