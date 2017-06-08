-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Máquina: localhost
-- Data de Criação: 10-Maio-2017 às 23:48
-- Versão do servidor: 5.5.49-0ubuntu0.14.04.1
-- versão do PHP: 5.5.9-1ubuntu4.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de Dados: `criptoRace`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `acertoCandidato`
--

CREATE TABLE IF NOT EXISTS `acertoCandidato` (
  `idAcertos` int(11) NOT NULL AUTO_INCREMENT,
  `idDesafio` int(11) DEFAULT NULL,
  `idRespostaSubmetida` int(11) DEFAULT NULL,
  PRIMARY KEY (`idAcertos`),
  KEY `fk_acertoCandidato_desafios` (`idDesafio`),
  KEY `fk_acertoCandidato_respostaSubmetida` (`idRespostaSubmetida`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=45 ;

--
-- Extraindo dados da tabela `acertoCandidato`
--

INSERT INTO `acertoCandidato` (`idAcertos`, `idDesafio`, `idRespostaSubmetida`) VALUES
(43, 29, 62),
(44, 41, 64);

-- --------------------------------------------------------

--
-- Estrutura da tabela `candidato`
--

CREATE TABLE IF NOT EXISTS `candidato` (
  `idCandidato` int(11) NOT NULL AUTO_INCREMENT,
  `nomeCompleto` varchar(100) NOT NULL,
  `nick` varchar(100) DEFAULT NULL,
  `matriculaIFG` varchar(30) DEFAULT NULL,
  `cpf` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`idCandidato`),
  UNIQUE KEY `matriculaIFG` (`matriculaIFG`),
  UNIQUE KEY `matriculaIFG_2` (`matriculaIFG`),
  KEY `cpf_2` (`cpf`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Extraindo dados da tabela `candidato`
--

INSERT INTO `candidato` (`idCandidato`, `nomeCompleto`, `nick`, `matriculaIFG`, `cpf`) VALUES
(1, 'teste', 'teste', 'teste', 'teste'),
(2, 'Victor Hugo Lázaro Lopes', 'hullopes', '', '940.053.971-15'),
(3, 'Tatuapu Caiauara', 'Tatuapu', '201700000000', ''),
(6, 'fulano de tal', 'fulano', '111', '');

-- --------------------------------------------------------

--
-- Estrutura da tabela `contest`
--

CREATE TABLE IF NOT EXISTS `contest` (
  `idContest` int(11) NOT NULL AUTO_INCREMENT,
  `nomeContest` varchar(200) NOT NULL,
  `status` enum('Ativo','Inativo') DEFAULT NULL,
  `loc` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idContest`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `contest`
--

INSERT INTO `contest` (`idContest`, `nomeContest`, `status`, `loc`) VALUES
(1, 'CriptoRace v1.0 2017', 'Ativo', 'Câmpus Inhumas IFG');

-- --------------------------------------------------------

--
-- Estrutura da tabela `desafios`
--

CREATE TABLE IF NOT EXISTS `desafios` (
  `idDesafio` int(11) NOT NULL AUTO_INCREMENT,
  `descricaoDesafio` varchar(300) NOT NULL,
  `idContest` int(11) NOT NULL,
  `status` enum('Ativo','Inativo') NOT NULL,
  `pontuacao` int(1) NOT NULL,
  PRIMARY KEY (`idDesafio`),
  KEY `fk_desafios_contest` (`idContest`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=107 ;

--
-- Extraindo dados da tabela `desafios`
--

INSERT INTO `desafios` (`idDesafio`, `descricaoDesafio`, `idContest`, `status`, `pontuacao`) VALUES
(1, 'Desafio teste - Basta responder o nome do coordenador Victor Hugo', 1, 'Ativo', 1),
(2, 'Responder o acrônimo do curso', 1, 'Ativo', 2),
(3, '1.Quebrar a frase, que pergunta o nome do evento número 10', 1, 'Ativo', 3),
(4, '2. Descobrir a frase que esta no código HTML da pagina - "Agora a diversão vai começar"', 1, 'Ativo', 1),
(5, '3. Descobrir a frase que esta no código HTML da pagina', 1, 'Ativo', 1),
(6, '4. Descobrir a frase que esta no código HTML da pagina. Pode responder em inglês e/ou português.', 1, 'Ativo', 1),
(7, '5. Msgs em código morse', 1, 'Ativo', 1),
(8, '6. Converter a cor que está em Hexadecimal, padrão CSS', 1, 'Ativo', 1),
(9, '6. Converter a cor que está em Hexadecimal, padrão CSS', 1, 'Ativo', 1),
(10, '7. O hash faz parte da composição do nome da imagem, onde há uma indicação do MD5. O participante deve informar o valor da soma de fatoriais', 1, 'Ativo', 10),
(11, '8.troca de letras por números', 1, 'Ativo', 1),
(12, '9. troca de letras por números', 1, 'Ativo', 1),
(13, '47. MENSAGEM ENVIADA EM E-MAIL DE DIVULGAÇÃO', 1, 'Ativo', 1),
(14, '48.MENSAGEM ENVIADA EM E-MAIL DE DIVULGAÇÃO', 1, 'Ativo', 1),
(15, '49. MENSAGEM ENVIADA EM E-MAIL DE DIVULGAÇÃO (SEGUNDA)', 1, 'Ativo', 1),
(16, '46. IMAGEM IMPRESSA EM CARTAZ, QUE REPRESENTA O NÚMERO 4 INCLINADO', 1, 'Ativo', 2),
(17, '45. CONVERTER CADA NÚMERO DE 2 ALGARISMOS EM UMA LETRA CORRESPONDENTE A SUA POSIÇÃO NO ALFABETO', 1, 'Ativo', 2),
(18, '44. É SÓ UMA FOTO DELE, PRA VER SE ESSE POVO SE ATENTA', 1, 'Ativo', 1),
(19, '43. a imagem do desafio 7 representa ambiguidade e ilusão de otica', 1, 'Ativo', 2),
(20, '42.Um cartaz com QRCode está escrito com troca das letras', 1, 'Ativo', 1),
(21, '41. nome da imagem criptografada', 1, 'Ativo', 2),
(22, '50. exercicio 41 usa vila do chaves no nome da imagem. Agora vamos ver se o cara responde o que lembra a imagem', 1, 'Ativo', 1),
(23, '10. Descobrir a frase escondida em uma página branca', 1, 'Ativo', 3),
(24, '11. Realizar a soma de binários', 1, 'Ativo', 2),
(25, '13. Descriptografar a msg que foi criptografado na base 64 por 2 vezes', 1, 'Ativo', 8),
(26, '14. Descriptografar a expressão e resolver. Caracteres de escape', 1, 'Ativo', 3),
(27, '15. Descriptografar Hexadecimal --> ASCII', 1, 'Ativo', 3),
(28, '16. Descriptografar a msg de hexadecimal --> ASCII --> Base-64 p/ encontrar o ISBN de um livro da biblioteca', 1, 'Ativo', 2),
(29, '17. O participante deve ter resolvido a msg com ID 16. A msg vai estar no livro "Criptografia e segurança de redes: princípios e práticas / William Stallings; tradução Daniel Vieira; revisão técnica Grassa Bressan, Ákio Barbosa e Marcelo Succi. ", tombado com o número 130928', 1, 'Inativo', 10),
(30, '18. Converter de binário --> ASCII', 1, 'Ativo', 1),
(31, '19. Descriptografar a parte da msg de Binária --> Hexadecimal, posteriormente descriptografar toda a msg de Hexadecimal --> ASCII', 1, 'Ativo', 5),
(32, '21. basta reverter o texto e responder o ano', 1, 'Ativo', 1),
(33, '21. basta reverter o texto e responder', 1, 'Ativo', 1),
(34, '25. Para descriptografar é necessário rodar 5 vezes o decryptor', 1, 'Ativo', 8),
(35, '27. Descriptografar utilizando ESAB-64, posterioremente utilizar RC4 com a chave a qual o professor Thyago sabe', 1, 'Ativo', 10),
(36, '51. Reverter texto', 1, 'Ativo', 1),
(37, '28. Descriptografar msg Reverter o texto e responder o que se pede.', 1, 'Ativo', 3),
(38, '36. Há uma foto do alan turing no cartaz do evento', 1, 'Ativo', 3),
(39, '40. nome da imagem criptografada', 1, 'Ativo', 1),
(40, '39. nome da imagem criptografada', 1, 'Ativo', 1),
(41, '38. Enviei mensagem de divulgação pros alunos, com 5! no fim.', 1, 'Ativo', 1),
(42, '37. Há uma foto da máquina de enigma no cartaz do evento', 1, 'Ativo', 3),
(43, '52. mandei frase no grupo da FSW', 1, 'Ativo', 2),
(44, '26. Descriptografar utilizando ESAB-64', 1, 'Ativo', 5),
(45, '25. Link para o site de descriptografia', 1, 'Ativo', 8),
(46, '23. descriptografar com chave cryptorace', 1, 'Ativo', 8),
(47, '53. Reverter Texto', 1, 'Ativo', 1),
(48, '54. Trocar números por letras', 1, 'Ativo', 1),
(49, '55. Trocar números por letras', 1, 'Ativo', 1),
(50, '56. Trocar números por letras', 1, 'Ativo', 1),
(51, '57. o QRcode vai mandar para uma busca de imagens de uma banda', 1, 'Ativo', 1),
(52, '58. O qRcode vai mandar para uma busca de imagens de uma DUPLA SERTANEJA', 1, 'Ativo', 1),
(53, '59. usar conversor de morse para ascii', 1, 'Ativo', 2),
(54, '60. Imagem do super mário no cartaz da maratona de programação.', 1, 'Ativo', 3),
(55, '61. imagem do power ranger rosa no cartaz da maratona', 1, 'Ativo', 3),
(56, '62. imagem de um abacaxi no cartaz da maratona', 1, 'Ativo', 3),
(57, '63. Código morse afixado na porta do banheiro feminino do térreo', 1, 'Ativo', 3),
(58, '64. Código morse afixado na porta do banheiro feminino do superior', 1, 'Ativo', 3),
(59, '65. Código morse afixado na porta do banheiro masculino térreo', 1, 'Ativo', 3),
(60, '66. Código morse afixado na porta do banheiro masculino SUPERIOR', 1, 'Ativo', 3),
(61, '67. representando 1 mil como kilo', 1, 'Ativo', 1),
(62, '68. Converter binary p/ ascii', 1, 'Ativo', 2),
(63, '69. Converter binary p/ ascii, depois reverter', 1, 'Ativo', 5),
(64, '70. Basta trocar os números por letras e responder.', 1, 'Ativo', 1),
(65, '71. TEXTO ESPELHADO puxe a cadeira', 1, 'Ativo', 2),
(66, '72. TEXTO ESPELHADO - VAMOS RECICLAR', 1, 'Ativo', 2),
(67, '73. TEXTO INVERTIDO ESPELHADO - CADEIRA', 1, 'Ativo', 3),
(68, '74. NÃO ESTÁ CRIPTOGRAFADA - LÓGICA', 1, 'Ativo', 1),
(69, '75. GIF ANIMADO COM SÍMBOLOS DA LIBRAS INDICANDO UMA PALAVRA', 1, 'Ativo', 4),
(70, '76. GIF ANIMADO COM RESPOSTA SÓ NO FIM, BEM RÁPIDO', 1, 'Ativo', 3),
(71, '77. GIF ANIMADO COM SEQUÊNCIA DE PALAVRAS EM SHA1', 1, 'Ativo', 4),
(72, '78. Há uma dica no HTML para o cara que está vendo o desafio 76. Se houver inteligência, ele manda a dica também!', 1, 'Ativo', 1),
(73, '79. jogo lógico, pra saber em qual vaga está o carro, e não pra saber o número escrito na vaga', 1, 'Ativo', 1),
(74, '80. Há algo inusitado no meio do café?', 1, 'Ativo', 1),
(75, '81. Encontrar no estereograma uma informação', 1, 'Ativo', 8),
(76, '82. Encontrar no estereograma uma informação - uma linguagem de programação', 1, 'Ativo', 4),
(77, '83. mensagem está em qrcode e na perna do piloto', 1, 'Ativo', 4),
(78, '84. piloto: horário no relógio do piloto', 1, 'Ativo', 3),
(79, '85. broche do piloto: chimps', 1, 'Ativo', 1),
(80, '86. broche do piloto: força aérea', 1, 'Ativo', 1),
(81, '87. broche do piloto: marinha', 1, 'Ativo', 1),
(82, '88. capacete do piloto: umbrella', 1, 'Ativo', 1),
(83, '89. reflexo da viseira do piloto', 1, 'Ativo', 1),
(84, '90. nome do piloto remete ao sgt pincel', 1, 'Ativo', 5),
(85, '91. slogan do FEB na segunda guerra mundial', 1, 'Ativo', 5),
(86, '92. broche do piloto: dica do extintor', 1, 'Ativo', 2),
(87, '93. É um arquivo editável do GIMP, em que a resposta está em uma camada abaixo de uma imagem chapada.', 1, 'Ativo', 20),
(88, '94. Pegar o nome da banda e música, conforme aparece na abertura do clipe', 1, 'Ativo', 1),
(89, '95. indicar qual item retorna false', 1, 'Ativo', 1),
(90, '100. imagem do filme', 1, 'Ativo', 1),
(91, '96. quadro no fundo harry potter', 1, 'Ativo', 1),
(92, '98. quadro no fundo - star trek', 1, 'Ativo', 1),
(93, '98. quadro no fundo freddy krueger', 1, 'Ativo', 2),
(94, '99. texto no fundo do chamado', 1, 'Ativo', 1),
(95, '12. indicando que existe algo na biblioteca', 1, 'Ativo', 3),
(96, '22. Descriptografar o texto de String --> código morse', 1, 'Ativo', 1),
(97, '27. Descriptografar utilizando ESAB-64, posterioremente utilizar RC4 com a chave a qual o professor Thyago sabe', 1, 'Ativo', 10),
(98, '29. Descriptografar a msg de BASE 64 > morse> ascii. O participante vai ter que analisar a imagem vilaDoChaves.png para descobrir qual é o número contido na porta da Dona clotilde', 1, 'Ativo', 8),
(99, '30. Para cada pixel da imagem foi inserido 10 pixels. O participante só precisa se atentar para criar uma aplicação simples que realiza essa remoção de pixels', 1, 'Ativo', 10),
(100, '31. A imagem está em binário. O participante deve multiplicar cada pixel por 255 para ver a mensagem', 1, 'Ativo', 10),
(101, '101. texto reverso de um filme', 1, 'Ativo', 1),
(102, '28. Descriptografar msg Reverter o texto e responder o que se pede.', 1, 'Ativo', 3),
(103, '110. Easter Eggs do linux. O comando será impresso no cartaz.', 1, 'Ativo', 3),
(104, '107. Latitude e longitude de Stonehenge - Impresso direto no cartaz', 1, 'Ativo', 2),
(105, '107. Latitude e longitude do Taj Mahal- reverso', 1, 'Ativo', 3),
(106, '106. colocar figura1', 1, 'Ativo', 3);

-- --------------------------------------------------------

--
-- Estrutura da tabela `inativos`
--

CREATE TABLE IF NOT EXISTS `inativos` (
  `idInativos` int(11) NOT NULL AUTO_INCREMENT,
  `idDesafio` int(11) NOT NULL,
  PRIMARY KEY (`idInativos`),
  KEY `fk_inativos_desafios` (`idDesafio`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `inativos`
--

INSERT INTO `inativos` (`idInativos`, `idDesafio`) VALUES
(1, 29);

-- --------------------------------------------------------

--
-- Estrutura da tabela `respDesafio`
--

CREATE TABLE IF NOT EXISTS `respDesafio` (
  `idResp` int(11) NOT NULL AUTO_INCREMENT,
  `resposta` longtext NOT NULL,
  `idDesafio` int(11) DEFAULT NULL,
  PRIMARY KEY (`idResp`),
  KEY `fk_respDesafio_desafios` (`idDesafio`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=139 ;

--
-- Extraindo dados da tabela `respDesafio`
--

INSERT INTO `respDesafio` (`idResp`, `resposta`, `idDesafio`) VALUES
(1, 'Victor Hugo', 1),
(2, 'bsi', 2),
(3, 'Incidente Shag Harbour', 3),
(4, 'Agora a diversão vai começar', 4),
(5, 'Do. Or do not. There is no try', 5),
(6, 'Do. Or do not. There is no try.', 5),
(7, 'Faz. Ou não. Não há tentativa.', 5),
(8, 'Faz. Ou não. Não há tentativa', 5),
(9, 'The ability to speak does not make you intelligent', 6),
(10, 'The ability to speak does not make you intelligent.', 6),
(11, 'A habilidade de falar não te faz inteligente', 6),
(12, 'A habilidade de falar não te faz inteligente.', 6),
(13, 'NO EGIPTO, ESTES LUGARES ERAM CHAMADOS TESOURO DOS REMDIOS DA ALMA. DE FATO  NELES QUE SE CURA A IGNORNCIA, A MAIS PERIGOSA DAS ENFERMIDADES E A ORIGEM DE TODAS AS OUTRAS. ESTE LUGAR CONTEM MUITA SABEDORIA E PONTOS', 7),
(14, 'amarelo', 9),
(15, 'yellow', 9),
(16, '122', 10),
(17, 'IMPRESSIONANTES', 11),
(18, 'CAFÉ COM LEITE', 12),
(19, 'SERÁ MUITO LEGAL', 13),
(20, 'SERÁ QUE VC CONSEGUE ENCONTRAR ALGUMA MENSAGEM?', 14),
(21, 'QUE COMECEM OS JOGOS', 15),
(22, '4', 16),
(23, 'QUATRO', 16),
(24, 'SILVIO SANTOS', 17),
(25, 'MICHAEL JACKSON', 18),
(26, 'Ambiguidade', 19),
(27, 'CRIPTORACE', 20),
(28, 'Vila do Chaves', 21),
(29, 'chaves', 22),
(30, 'SERÁ ESTA A RESPOSTA QUE ESTÁ PROCURANDO?', 23),
(31, '100', 24),
(32, 'Tem mensagem na quadra de esportes!', 25),
(33, '2', 26),
(34, 'Olá mundo!', 27),
(35, 'ISBN=9788576051190', 28),
(36, '9788576051190', 28),
(37, 'Você ganhou 10 pontos. Destrua esta msg!', 29),
(38, 'Que a força esteja com você!', 30),
(39, 'PLATÃO', 31),
(40, '2017', 32),
(41, 'Palmeiras não tem mundial', 33),
(42, 'Me Pegou!', 34),
(43, 'Bem vindo aos Jogos Vorazes, e que a sorte esteja sempre ao seu favor.', 35),
(44, 'Pra crescer é preciso saber a diferença entre esperar e perder tempo', 36),
(45, 'Dicionário', 37),
(46, 'Dictionary', 37),
(47, 'Alan Turing', 38),
(48, 'IFG Campus Inhumas', 39),
(49, 'IFG Câmpus Inhumas', 39),
(50, 'frase Cripto', 40),
(51, '120', 41),
(52, 'Enigma', 42),
(53, 'Máquina Enigma', 42),
(54, 'Máquina de Enigma', 42),
(55, 'Bônus', 43),
(56, 'Eu sou o cara', 44),
(57, 'http://crypo.pw/encryptors', 45),
(58, 'crypo.pw/encryptors', 45),
(59, 'Só os fortes pegarão esta!', 46),
(60, 'Sou competidor da CriptoRACE', 47),
(61, 'IFG GOIAS', 48),
(62, 'IFG GOIÁS', 48),
(63, 'ROLLING STONES', 49),
(64, 'THE BLACK EYED PEAS', 50),
(65, 'THE WHO', 51),
(66, 'TONICO E TINOCO', 52),
(67, 'TONICO & TINOCO', 52),
(68, 'chimps can do it better', 53),
(69, 'Chimpanzés podem fazer isso melhor', 53),
(70, 'super mário', 54),
(71, 'super mário world', 54),
(72, 'power ranger rosa', 55),
(73, 'power ranger', 55),
(74, 'Ranger Rosa', 55),
(75, 'abacaxi', 56),
(76, 'cabeça de abacaxi', 56),
(77, 'BANHEIRO FEMININO 1', 57),
(78, 'BANHEIRO FEMININO 2', 58),
(79, 'BANHEIRO MASCULINO 1', 59),
(80, 'BANHEIRO MASCULINO 2', 60),
(81, '2017', 61),
(82, 'JÁ OLHOU NA BIBLIOTECA?', 62),
(83, 'ESTA É UMA ÁRVORE!', 63),
(84, 'ESTA É OUTRA ÁRVORE!', 64),
(85, 'ESTA E OUTRA ARVORE!', 64),
(86, 'PUXE A CADEIRA E SENTE-SE NO CHÃO', 65),
(87, 'VAMOS RECICLAR!!', 66),
(88, 'ESTA É UMA CADEIRA', 67),
(89, 'ABRA ESTA PÁGINA EM UM COMPUTADOR!', 68),
(90, 'LIBRAS', 69),
(91, 'THE WALKING DEAD', 70),
(92, 'MEU NOME NAO E JHONY', 71),
(93, 'MEU NOME NÃO É JHONY', 71),
(94, 'espere até o fim', 72),
(95, 'quinta vaga', 73),
(96, 'quinta', 73),
(97, '5ª', NULL),
(98, 'vaga número 5', NULL),
(99, 'bebê', 74),
(100, 'bebês', 74),
(101, 'joaninha', 74),
(102, 'joaninhas', 74),
(103, 'joaninhas e bebês', 74),
(104, 'SI', 75),
(105, 'PHP', 76),
(106, 'king kong', 77),
(107, '11:40', 78),
(108, 'chimps', 79),
(109, 'chimpanzés', 79),
(110, 'força aérea brasileira', 80),
(111, 'fab', 80),
(112, 'Força aérea', 80),
(113, 'Marinha do Brasil', 81),
(114, 'Umbrella Corporation', 82),
(115, 'delorean', 83),
(116, 'Os Trapalhões', 84),
(117, 'A cobra vai fumar', 85),
(118, 'A cobra vai fumar!', 85),
(119, 'Procure no Extintor', 86),
(120, 'Rock Balboa', 87),
(121, 'Pearl Jam - Black', 88),
(122, '9', 89),
(123, 'O Chamado', 90),
(124, 'harry potter', 91),
(125, 'star trek', 92),
(126, 'Freddy Krueger', 93),
(127, 'Explorar é uma arte', 94),
(128, 'biblioteca', 95),
(129, 'THE BOOK IS ON THE TABLE', 96),
(130, 'Bem vindo aos Jogos Vorazes, e que a sorte esteja sempre ao seu favor.', 97),
(131, '85', 98),
(132, 'STARK', 99),
(133, 'BENJAMIN FRANKLIN', 100),
(134, 'Laranja Mecânica', 101),
(135, 'Have you mooed today?', 103),
(136, 'Stonehenge', 104),
(137, 'taj Mahal', 105),
(138, 'Nintendo', 106);

-- --------------------------------------------------------

--
-- Estrutura da tabela `respostaSubmetida`
--

CREATE TABLE IF NOT EXISTS `respostaSubmetida` (
  `idRespSubmetida` int(11) NOT NULL AUTO_INCREMENT,
  `respostaSubmetida` longtext,
  `idCandidato` int(11) DEFAULT NULL,
  `idDesafio` int(11) DEFAULT NULL,
  PRIMARY KEY (`idRespSubmetida`),
  KEY `fk_respostaSubmetida_candidato` (`idCandidato`),
  KEY `fk_respostaSubmetida_desafios` (`idDesafio`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=66 ;

--
-- Extraindo dados da tabela `respostaSubmetida`
--

INSERT INTO `respostaSubmetida` (`idRespSubmetida`, `respostaSubmetida`, `idCandidato`, `idDesafio`) VALUES
(57, 'você ganhou 10 pontos. destrua esta msg!', 1, 29),
(58, 'você ganhou 10 pontos. destrua esta msg!', 1, 29),
(59, 'você ganhou 10 pontos. destrua esta msg!', 1, 29),
(60, 'você ganhou 10 pontos. destrua esta msg!', 1, 29),
(61, 'você ganhou 10 pontos. destrua esta msg!', 1, 29),
(62, 'você ganhou 10 pontos. destrua esta msg!', 1, 29),
(63, 'você ganhou 10 pontos. destrua esta msg!', 1, 29),
(64, '120', 1, 41),
(65, '120', 1, 41);

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `acertoCandidato`
--
ALTER TABLE `acertoCandidato`
  ADD CONSTRAINT `fk_acertoCandidato_desafios` FOREIGN KEY (`idDesafio`) REFERENCES `desafios` (`idDesafio`),
  ADD CONSTRAINT `fk_acertoCandidato_respostaSubmetida` FOREIGN KEY (`idRespostaSubmetida`) REFERENCES `respostaSubmetida` (`idRespSubmetida`);

--
-- Limitadores para a tabela `desafios`
--
ALTER TABLE `desafios`
  ADD CONSTRAINT `fk_desafios_contest` FOREIGN KEY (`idContest`) REFERENCES `contest` (`idContest`);

--
-- Limitadores para a tabela `inativos`
--
ALTER TABLE `inativos`
  ADD CONSTRAINT `fk_inativos_desafios` FOREIGN KEY (`idDesafio`) REFERENCES `desafios` (`idDesafio`);

--
-- Limitadores para a tabela `respDesafio`
--
ALTER TABLE `respDesafio`
  ADD CONSTRAINT `fk_respDesafio_desafios` FOREIGN KEY (`idDesafio`) REFERENCES `desafios` (`idDesafio`);

--
-- Limitadores para a tabela `respostaSubmetida`
--
ALTER TABLE `respostaSubmetida`
  ADD CONSTRAINT `fk_respostaSubmetida_candidato` FOREIGN KEY (`idCandidato`) REFERENCES `candidato` (`idCandidato`),
  ADD CONSTRAINT `fk_respostaSubmetida_desafios` FOREIGN KEY (`idDesafio`) REFERENCES `desafios` (`idDesafio`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
