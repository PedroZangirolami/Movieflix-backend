# Movieflix casos de uso

Backend de uma aplicação de consulta e avaliação de filmes onde é necessário realizar o login para poder ter acesso a consulta de  filmes e avaliações existem duas categorias de usuários (membro e visitante)  onde apenas usuários membros podem deixar avaliações já consultas podem ser realizadas por qualquer usuário logado.

## Funcionalidades:

Autenticação:
|Metodo http|EndPoints|Descrição|
|---|---|---|
|POST|/oauth2/token|Executa o login e retorna o token do usuário|

Usuário:
|Metodo http|EndPoints|Descrição|
|---|---|---|
|GET|/users/profile|Retorna o usuário logado|

Movies:
|Metodo http|EndPoints|Descrição|
|---|---|---|
|GET|/movies?genreId=1&page=0&size=6|Faz uma busca paginada dos filmes por gênero|
|GET|/movies/:id|Retorna detalhes de filme pelo id|
|GET|/movies/:id/reviews|Retorna as avaliações de um filme pelo id|

Genre:
|Metodo http|EndPoints|Descrição|
|---|---|---|
|GET|/genres|Retorna todos os gêneros de filmes|


Review:
|Metodo http|EndPoints|Descrição|
|---|---|---|
|POST|/reviews|Insere uma nova avaliação para um filme|

