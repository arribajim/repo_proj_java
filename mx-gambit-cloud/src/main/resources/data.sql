delete from Taco_Order_Tacos;
delete from Taco_Ingredients;
delete from Taco;
delete from Taco_Order;

delete from Ingredient;
insert into Ingredient (id, name, type) 
                values ('FLTO', 'Flour Tortilla', 'WRAP');
insert into Ingredient (id, name, type) 
                values ('COTO', 'Corn Tortilla', 'WRAP');
insert into Ingredient (id, name, type) 
                values ('GRBF', 'Ground Beef', 'PROTEIN');
insert into Ingredient (id, name, type) 
                values ('CARN', 'Carnitas', 'PROTEIN');
insert into Ingredient (id, name, type) 
                values ('TMTO', 'Diced Tomatoes', 'VEGGIES');
insert into Ingredient (id, name, type) 
                values ('LETC', 'Lettuce', 'VEGGIES');
insert into Ingredient (id, name, type) 
                values ('CHED', 'Cheddar', 'CHEESE');
insert into Ingredient (id, name, type) 
                values ('JACK', 'Monterrey Jack', 'CHEESE');
insert into Ingredient (id, name, type) 
                values ('SLSA', 'Salsa', 'SAUCE');
insert into Ingredient (id, name, type) 
                values ('SRCR', 'Sour Cream', 'SAUCE');


insert into countries values ( 107082063, 'México', 'MX', 1009900);
insert into countries values ( 103849350, 'Internacional', 'INT1', 1009890);
insert into countries values ( 103849006, 'Clubes Internacional', 'INT2', 1009880);
insert into countries values ( 103852953, 'España', 'ES', 1009810);
insert into countries values ( 103844921, 'Inglaterra', 'UK', 1009800);
insert into countries values ( 103846115, 'Alemania', 'DE', 1009790);
insert into countries values ( 103856867, 'Italia', 'IT', 1009780);
insert into countries values ( 109236511, 'Argentina', 'AR', 1009778);
insert into countries values ( 108372450, 'Brasil', 'BR', 1009773);
insert into countries values ( 103850653, 'Francia', 'FR', 1009770);
insert into countries values ( 103850106, 'Portugal', 'PT', 1009760);
insert into countries values ( 103862954, 'Países Bajos', 'NL', 1009750);
insert into countries values ( 103845677, 'Bolivia', 'BO', 1009680);
insert into countries values ( 115163652, 'Colombia', 'CO', 1009660);
insert into countries values ( 103865726, 'Austria', 'AT', 1009550);
insert into countries values ( 103845997, 'Bélgica', 'BE', 1009540);
insert into countries values ( 128749693, 'Dinamarca', 'DK', 1009530);
insert into countries values ( 103843410, 'Escocia', 'SCO', 1009520);
insert into countries values ( 103868635, 'Polonia', 'PL', 1009500);
insert into countries values ( 117923383, 'Suiza', 'CH', 1009470);
insert into countries values ( 103859380, 'Turquía', 'TR', 1009460);
insert into countries values ( 103848750, 'Costa Rica', 'CR', 1009380);
insert into countries values ( 114026845, 'Guatemala', 'GT', 1009360);
insert into countries values ( 114282526, 'Honduras', 'HN', 1009350);
insert into countries values ( 103844889, 'Australia', 'AU', 1009300);
insert into countries values ( 103915950, 'Bulgaria', 'BG', 1009150);
insert into countries values ( 103850074, 'Chipre', 'CY', 1009140);
insert into countries values ( 103852476, 'Croacia', 'HR', 1009130);
insert into countries values ( 103862940, 'Gales', 'WF', 1009080);
insert into countries values ( 103859702, 'Grecia', 'GR', 1009050);
insert into countries values ( 132877766, 'Hungría', 'HU', 1009040);
insert into countries values ( 138947943, 'Irlanda', 'IE', 1009030);
insert into countries values ( 103850635, 'Irlanda del Norte', 'NI', 1009020);
insert into countries values ( 117718105, 'Islandia', 'IS', 1009010);
insert into countries values ( 103860756, 'Israel', 'IL', 1008990);
insert into countries values ( 129994528, 'Rep. Checa', 'CZ', 1008890);
insert into countries values ( 103845323, 'Rumanía', 'RO', 1008880);
insert into countries values ( 104852396, 'Argelia', 'DZ', 1008800);
insert into countries values ( 104594743, 'Baréin', 'BH', 1008690);
insert into countries values ( 104111541, 'India', 'IN', 1008630);
insert into countries values ( 111390797, 'Iran', 'IR', 1008610);
insert into countries values ( 122561200, 'Kuwait', 'KW', 1008570);
insert into countries values ( 103897631, 'Catar', 'QA', 1008530);
insert into countries values ( 104594970, 'Arabia Saudí', 'SA', 1008520);


insert into countries values ( 112673186, 'Suecia', 'NA', 1000);
insert into leagues values ( 107082495, 'Liga MX', 9900, 107082063);
insert into leagues values ( 116182462, 'Copa MX', 9890, 107082063);

insert into leagues values ( 1664178593, 'Clasificación Eurocopa', 9900, 103849350);
insert into leagues values ( 444229735, 'Copa América 2020', 9895, 103849350);
insert into leagues values ( 242665965, 'Eurocopa 2020', 9880, 103849350);

insert into leagues values ( 113871618, 'CONMEBOL Libertadores', 9895, 103849006);
insert into leagues values ( 103849007, 'UEFA Champions League', 9890, 103849006);
insert into leagues values ( 103881073, 'UEFA Europa League', 9880, 103849006);
insert into leagues values ( 203284827, 'CONMEBOL Sudamericana', 9835, 103849006);
insert into leagues values ( 103849351, 'Amistosos de Clubes', 9780, 103849006);

--insert into leagues values ( 2191490312, 'Especiales Champions League 19/20 - Fútbol', 0, 358531209);
insert into leagues values ( 103852954, 'Primera División', 9900, 103852953);
insert into leagues values ( 103875849, 'Copa del Rey', 9880, 103852953);
insert into leagues values ( 103867864, 'Segunda División', 9870, 103852953);

--insert into leagues values ( 870501653, 'Especiales Real Madrid - Fútbol', 0, 358531193);
insert into leagues values ( 103846129, 'Premier League', 9900, 103844921);
insert into leagues values ( 103856044, 'Championship', 9860, 103844921);
insert into leagues values ( 103865233, 'League One', 9850, 103844921);
insert into leagues values ( 103844944, 'League Two', 9840, 103844921);
insert into leagues values ( 103869216, 'Conference Premier', 9820, 103844921);
insert into leagues values ( 103844922, 'Conference Norte', 0, 103844921);
insert into leagues values ( 103868607, 'Conference Sur', 0, 103844921);
insert into leagues values ( 308341500, 'Premier Division', 0, 103844921);
insert into leagues values ( 251275137, 'Superliga FA Femenina Inglesa ', 0, 103844921);
insert into leagues values ( 103860942, 'Bundesliga', 9900, 103846115);
insert into leagues values ( 114262893, 'Copa Alemania', 9870, 103846115);
insert into leagues values ( 103852483, 'Bundesliga II', 9860, 103846115);
insert into leagues values ( 103846116, '3. Liga Alemania', 9840, 103846115);
insert into leagues values ( 119303793, 'Regionalliga Norte', 9830, 103846115);

insert into leagues values ( 103856868, 'Serie A', 9900, 103856867);
insert into leagues values ( 103867803, 'Copa de Italia', 9880, 103856867);
insert into leagues values ( 103873182, 'Serie B', 9870, 103856867);

insert into leagues values ( 122051762, 'Superliga Argentina', 9900, 109236511);
insert into leagues values ( 2560682004, 'Copa Argentina - Clasificación', 0, 109236511);
insert into leagues values ( 654511323, 'Primera D Metropolitana', 0, 109236511);
insert into leagues values ( 122713282, 'Copa de Brasil', 9890, 108372450);
insert into leagues values ( 112040430, 'Campeonato Carioca', 9870, 108372450);
insert into leagues values ( 114116910, 'Campeonato Pernambucano', 9830, 108372450);
insert into leagues values ( 115755045, 'Campeonato Mineiro', 9780, 108372450);
insert into leagues values ( 123841076, 'Paulista ', 9450, 108372450);
insert into leagues values ( 985876494, 'Campeonato Alagoano', 0, 108372450);
insert into leagues values ( 1225930430, 'Campeonato Capixaba', 0, 108372450);
insert into leagues values ( 934113401, 'Campeonato Paulista A3', 0, 108372450);
insert into leagues values ( 928325365, 'Campeonato Potiguar ', 0, 108372450);
insert into leagues values ( 2618495218, 'Supercopa de Brasil', 0, 108372450);
insert into leagues values ( 103879105, 'Ligue 1', 9900, 103850653);
insert into leagues values ( 107264217, 'Copa de Francia', 9880, 103850653);
insert into leagues values ( 103867164, 'Ligue 2', 9860, 103850653);
insert into leagues values ( 104331422, 'Championnat National', 9850, 103850653);
insert into leagues values ( 103877464, 'Primeira Liga', 9900, 103850106);
insert into leagues values ( 107283426, 'Copa Portugal', 9890, 103850106);

/*insert into events values ( 2085580977, 'Mallorca - Alavés','2020-02-15 06:00:00.000', 0, false, '18641108', 103852954);
insert into events values ( 2085580322, 'Athletic - Osasuna','2020-02-16 11:30:00.000', 0, false, '18641098', 103852954);
insert into events values ( 2085583326, 'Barcelona - Getafe','2020-02-15 09:00:00.000', 0, false, '18641100', 103852954);
insert into events values ( 2085581107, 'Real Madrid - Celta','2020-02-16 14:00:00.000', 0, false, '18641110', 103852954);
insert into events values ( 2085581517, 'Leganés - Betis','2020-02-16 07:00:00.000', 0, false, '18641106', 103852954);
insert into events values ( 2085583693, 'Eibar - Real Sociedad','2020-02-16 09:00:00.000', 0, false, '18641102', 103852954);
insert into events values ( 2085582583, 'Villarreal - Levante','2020-02-15 11:30:00.000', 0, false, '18641116', 103852954);
insert into events values ( 2085581217, 'Sevilla - Espanyol','2020-02-16 05:00:00.000', 0, false, '18641112', 103852954);
insert into events values ( 2085581386, 'Betis - Mallorca','2020-02-21 14:00:00.000', 0, false, '18641124', 103852954);
insert into events values ( 2085581443, 'Granada - Valladolid','2020-02-15 14:00:00.000', 0, false, '18641104', 103852954);
insert into events values ( 2085581588, 'Real Sociedad - Valencia','2020-02-22 11:30:00.000', 0, false, '18641134', 103852954);
insert into events values ( 2085582550, 'Real Madrid - Barcelona','2020-03-01 14:00:00.000', 0, false, '18641150', 103852954);
insert into events values ( 2085582769, 'Barcelona - Eibar','2020-02-22 09:00:00.000', 0, false, '18641122', 103852954);
insert into events values ( 2085583413, 'Valencia - Atlético','2020-02-14 14:00:00.000', 0, false, '18641114', 103852954);
insert into events values ( 2085584693, 'Alavés - Athletic','2020-02-23 07:00:00.000', 0, false, '18641118', 103852954);
insert into events values ( 2085585209, 'Atlético - Villarreal','2020-02-23 14:00:00.000', 0, false, '18641120', 103852954);
insert into events values ( 2085585239, 'Levante - Real Madrid','2020-02-22 14:00:00.000', 0, false, '18641130', 103852954);
insert into events values ( 2085585367, 'Getafe - Sevilla','2020-02-23 11:30:00.000', 0, false, '18641128', 103852954);
insert into events values ( 2085585401, 'Celta - Leganés','2020-02-22 06:00:00.000', 0, false, '18641126', 103852954);
insert into events values ( 2085585859, 'Osasuna - Granada','2020-02-23 05:00:00.000', 0, false, '18641132', 103852954);
insert into events values ( 2085587267, 'Valladolid - Espanyol','2020-02-23 09:00:00.000', 0, false, '18641136', 103852954);

insert into events values ( 2599200546, 'Atlético San Luis - Club León','2020-02-14 19:00:00.000', 0, false, '20726947', 107082495);
insert into events values ( 2599322674, 'Monarcas Morelia - Club Tijuana','2020-02-14 21:00:00.000', 0, false, '20726949', 107082495);
insert into events values ( 2601344895, 'Pachuca - Puebla','2020-02-15 17:00:00.000', 0, false, '20726951', 107082495);
insert into events values ( 2603378184, 'Toluca - Pumas UNAM','2020-02-15 17:00:00.000', 0, false, '20726959', 107082495);
insert into events values ( 2601975946, 'América - Atlas','2020-02-15 19:00:00.000', 0, false, '', 107082495);
insert into events values ( 2601976527, 'Monterrey - FC Juárez','2020-02-15 19:06:00.000', 0, false, '20726955', 107082495);
insert into events values ( 2602123709, 'Guadalajara - Cruz Azul','2020-02-15 21:00:00.000', 0, false, '20726957', 107082495);
insert into events values ( 2603825776, 'Club Necaxa - Querétaro','2020-02-16 17:00:00.000', 0, false, '20726961', 107082495);
insert into events values ( 2603826249, 'Santos Laguna - Tigres UANL','2020-02-16 18:45:00.000', 0, false, '20726963', 107082495);
insert into events values ( 2614256692, 'Atlas - Pachuca','2020-02-21 19:00:00.000', 0, false, '20726965', 107082495);
insert into events values ( 2614419587, 'Puebla - Toluca','2020-02-21 21:00:00.000', 0, false, '20726967', 107082495);
insert into events values ( 2616466821, 'Club León - Club Necaxa','2020-02-22 17:00:00.000', 0, false, '20726971', 107082495);
insert into events values ( 2617109106, 'Cruz Azul - Tigres UANL','2020-02-22 19:00:00.000', 0, false, '20726973', 107082495);
insert into events values ( 2618446444, 'Pumas UNAM - Monarcas Morelia','2020-02-23 12:00:00.000', 0, false, '20726977', 107082495);
insert into events values ( 2619359722, 'FC Juárez - Santos Laguna','2020-02-23 19:00:00.000', 0, false, '20726981', 107082495);

insert into games values ( 2599200576, '1X2',9900, false, 2599200546);
insert into games values ( 2599322704, '1X2',9900, false, 2599322674);
insert into games values ( 2601344927, '1X2',9900, false, 2601344895);
insert into games values ( 2603378214, '1X2',9900, false, 2603378184);
insert into games values ( 2601975977, '1X2',9900, false, 2601975946);
insert into games values ( 2601976557, '1X2',9900, false, 2601976527);
insert into games values ( 2602123739, '1X2',9900, false, 2602123709);
insert into games values ( 2603825806, '1X2',9900, false, 2603825776);
insert into games values ( 2603826279, '1X2',9900, false, 2603826249);
insert into games values ( 2614256726, '1X2',9900, false, 2614256692);
insert into games values ( 2614419619, '1X2',9900, false, 2614419587);
insert into games values ( 2616466851, '1X2',9900, false, 2616466821);
insert into games values ( 2617109136, '1X2',9900, false, 2617109106);
insert into games values ( 2618446477, '1X2',9900, false, 2618446444);
insert into games values ( 2619359753, '1X2',9900, false, 2619359722);

insert into games values ( 2085580986, '1X2',9900, false, 2085580977);
insert into games values ( 2085580982, 'Altas/Bajas Total de Goles',9890, false, 2085580977);
insert into games values ( 2085580333, '1X2',9900, false, 2085580322);
insert into games values ( 2085580329, 'Altas/Bajas Total de Goles',9890, false, 2085580322);
insert into games values ( 2085583337, '1X2',9900, false, 2085583326);
insert into games values ( 2085583333, 'Altas/Bajas Total de Goles',9890, false, 2085583326);
insert into games values ( 2085581116, '1X2',9900, false, 2085581107);
insert into games values ( 2085581113, 'Altas/Bajas Total de Goles',9890, false, 2085581107);
insert into games values ( 2085581526, '1X2',9900, false, 2085581517);
insert into games values ( 2085581522, 'Altas/Bajas Total de Goles',9890, false, 2085581517);
insert into games values ( 2085583738, '1X2',9900, false, 2085583693);
insert into games values ( 2085583734, 'Altas/Bajas Total de Goles',9890, false, 2085583693);
insert into games values ( 2085582592, '1X2',9900, false, 2085582583);
insert into games values ( 2085582589, 'Altas/Bajas Total de Goles',9890, false, 2085582583);
insert into games values ( 2085581226, '1X2',9900, false, 2085581217);
insert into games values ( 2085581222, 'Altas/Bajas Total de Goles',9890, false, 2085581217);
insert into games values ( 2085581396, '1X2',9900, false, 2085581386);
insert into games values ( 2085581392, 'Altas/Bajas Total de Goles',9890, false, 2085581386);
insert into games values ( 2085581452, '1X2',9900, false, 2085581443);
insert into games values ( 2085581447, 'Altas/Bajas Total de Goles',9890, false, 2085581443);
insert into games values ( 2085581597, '1X2',9900, false, 2085581588);
insert into games values ( 2085581593, 'Altas/Bajas Total de Goles',9890, false, 2085581588);
insert into games values ( 2085582560, '1X2',9900, false, 2085582550);
insert into games values ( 2085582778, '1X2',9900, false, 2085582769);
insert into games values ( 2085582775, 'Altas/Bajas Total de Goles',9890, false, 2085582769);
insert into games values ( 2085583622, '1X2',9900, false, 2085583413);
insert into games values ( 2085583614, 'Altas/Bajas Total de Goles',9890, false, 2085583413);
insert into games values ( 2085584702, '1X2',9900, false, 2085584693);
insert into games values ( 2085584697, 'Altas/Bajas Total de Goles',9890, false, 2085584693);
insert into games values ( 2085585218, '1X2',9900, false, 2085585209);
insert into games values ( 2085585214, 'Altas/Bajas Total de Goles',9890, false, 2085585209);
insert into games values ( 2085585251, '1X2',9900, false, 2085585239);
insert into games values ( 2085585248, 'Altas/Bajas Total de Goles',9890, false, 2085585239);
insert into games values ( 2085585377, '1X2',9900, false, 2085585367);
insert into games values ( 2085585373, 'Altas/Bajas Total de Goles',9890, false, 2085585367);
insert into games values ( 2085585414, '1X2',9900, false, 2085585401);
insert into games values ( 2085585410, 'Altas/Bajas Total de Goles',9890, false, 2085585401);
insert into games values ( 2085585869, '1X2',9900, false, 2085585859);
insert into games values ( 2085585865, 'Altas/Bajas Total de Goles',9890, false, 2085585859);
insert into games values ( 2085587276, '1X2',9900, false, 2085587267);
insert into GAMBIT_RESULTS values ( 2085581001, 'Mallorca','2020-03-07 17:41:37.271', 2.45, 0, 'false', 2085580986);
insert into GAMBIT_RESULTS values ( 2085581002, 'Empate','2020-03-07 17:41:37.272', 3.0, 1, 'false', 2085580986);
insert into GAMBIT_RESULTS values ( 2085581003, 'Alavés','2020-03-07 17:41:37.272', 3.05, 2, 'false', 2085580986);
insert into GAMBIT_RESULTS values ( 2085580995, 'Altas 2.5','2020-03-07 17:41:37.272', 2.25, 0, 'false', 2085580982);
insert into GAMBIT_RESULTS values ( 2085580996, 'Bajas 2.5','2020-03-07 17:41:37.272', 1.6, 1, 'false', 2085580982);
insert into GAMBIT_RESULTS values ( 2085580348, 'Athletic','2020-03-07 17:41:37.273', 2.0, 0, 'false', 2085580333);
insert into GAMBIT_RESULTS values ( 2085580349, 'Empate','2020-03-07 17:41:37.273', 3.15, 1, 'false', 2085580333);
insert into GAMBIT_RESULTS values ( 2085580350, 'Osasuna','2020-03-07 17:41:37.273', 4.0, 2, 'false', 2085580333);
insert into GAMBIT_RESULTS values ( 2085580342, 'Altas 2.5','2020-03-07 17:41:37.273', 2.35, 0, 'false', 2085580329);
insert into GAMBIT_RESULTS values ( 2085580343, 'Bajas 2.5','2020-03-07 17:41:37.273', 1.55, 1, 'false', 2085580329);
insert into GAMBIT_RESULTS values ( 2085583352, 'Barcelona','2020-03-07 17:41:37.274', 1.4, 0, 'false', 2085583337);
insert into GAMBIT_RESULTS values ( 2085583353, 'Empate','2020-03-07 17:41:37.274', 4.4, 1, 'false', 2085583337);
insert into GAMBIT_RESULTS values ( 2085583354, 'Getafe','2020-03-07 17:41:37.274', 7.25, 2, 'false', 2085583337);
insert into GAMBIT_RESULTS values ( 2085583346, 'Altas 2.5','2020-03-07 17:41:37.275', 1.68, 0, 'false', 2085583333);
insert into GAMBIT_RESULTS values ( 2085583347, 'Bajas 2.5','2020-03-07 17:41:37.275', 2.1, 1, 'false', 2085583333);
insert into GAMBIT_RESULTS values ( 2085581131, 'Real Madrid','2020-03-07 17:41:37.275', 1.22, 0, 'false', 2085581116);
insert into GAMBIT_RESULTS values ( 2085581132, 'Empate','2020-03-07 17:41:37.276', 6.25, 1, 'false', 2085581116);
insert into GAMBIT_RESULTS values ( 2085581133, 'Celta','2020-03-07 17:41:37.276', 11.0, 2, 'false', 2085581116);
insert into GAMBIT_RESULTS values ( 2085581127, 'Altas 3.5','2020-03-07 17:41:37.276', 2.15, 0, 'false', 2085581113);
insert into GAMBIT_RESULTS values ( 2085581128, 'Bajas 3.5','2020-03-07 17:41:37.277', 1.65, 1, 'false', 2085581113);
insert into GAMBIT_RESULTS values ( 2085581541, 'Leganés','2020-03-07 17:41:37.277', 2.5, 0, 'false', 2085581526);
insert into GAMBIT_RESULTS values ( 2085581542, 'Empate','2020-03-07 17:41:37.277', 3.2, 1, 'false', 2085581526);
insert into GAMBIT_RESULTS values ( 2085581543, 'Betis','2020-03-07 17:41:37.277', 2.8, 2, 'false', 2085581526);
insert into GAMBIT_RESULTS values ( 2085581535, 'Altas 2.5','2020-03-07 17:41:37.278', 2.2, 0, 'false', 2085581522);
insert into GAMBIT_RESULTS values ( 2085581536, 'Bajas 2.5','2020-03-07 17:41:37.278', 1.62, 1, 'false', 2085581522);
insert into GAMBIT_RESULTS values ( 2085583753, 'Eibar','2020-03-07 17:41:37.278', 2.85, 0, 'false', 2085583738);
insert into GAMBIT_RESULTS values ( 2085583754, 'Empate','2020-03-07 17:41:37.279', 3.3, 1, 'false', 2085583738);
insert into GAMBIT_RESULTS values ( 2085583755, 'Real Sociedad','2020-03-07 17:41:37.279', 2.4, 2, 'false', 2085583738);
insert into GAMBIT_RESULTS values ( 2085583747, 'Altas 2.5','2020-03-07 17:41:37.279', 1.95, 0, 'false', 2085583734);
insert into GAMBIT_RESULTS values ( 2085583748, 'Bajas 2.5','2020-03-07 17:41:37.279', 1.8, 1, 'false', 2085583734);
insert into GAMBIT_RESULTS values ( 2085582607, 'Villarreal','2020-03-07 17:41:37.280', 1.45, 0, 'false', 2085582592);
insert into GAMBIT_RESULTS values ( 2085582608, 'Empate','2020-03-07 17:41:37.280', 4.5, 1, 'false', 2085582592);
insert into GAMBIT_RESULTS values ( 2085582609, 'Levante','2020-03-07 17:41:37.280', 6.5, 2, 'false', 2085582592);
insert into GAMBIT_RESULTS values ( 2085582603, 'Altas 3.5','2020-03-07 17:41:37.280', 2.15, 0, 'false', 2085582589);
insert into GAMBIT_RESULTS values ( 2085582604, 'Bajas 3.5','2020-03-07 17:41:37.281', 1.65, 1, 'false', 2085582589);
insert into GAMBIT_RESULTS values ( 2085581241, 'Sevilla','2020-03-07 17:41:37.281', 1.5, 0, 'false', 2085581226);
insert into GAMBIT_RESULTS values ( 2085581242, 'Empate','2020-03-07 17:41:37.281', 3.9, 1, 'false', 2085581226);
insert into GAMBIT_RESULTS values ( 2085581243, 'Espanyol','2020-03-07 17:41:37.282', 6.5, 2, 'false', 2085581226);
insert into GAMBIT_RESULTS values ( 2085581235, 'Altas 2.5','2020-03-07 17:41:37.282', 1.95, 0, 'false', 2085581222);
insert into GAMBIT_RESULTS values ( 2085581236, 'Bajas 2.5','2020-03-07 17:41:37.282', 1.8, 1, 'false', 2085581222);
insert into GAMBIT_RESULTS values ( 2085581411, 'Betis','2020-03-07 17:41:37.282', 1.45, 0, 'false', 2085581396);
insert into GAMBIT_RESULTS values ( 2085581412, 'Empate','2020-03-07 17:41:37.282', 4.4, 1, 'false', 2085581396);
insert into GAMBIT_RESULTS values ( 2085581413, 'Mallorca','2020-03-07 17:41:37.283', 6.25, 2, 'false', 2085581396);
insert into GAMBIT_RESULTS values ( 2085581405, 'Altas 2.5','2020-03-07 17:41:37.283', 1.65, 0, 'false', 2085581392);
insert into GAMBIT_RESULTS values ( 2085581406, 'Bajas 2.5','2020-03-07 17:41:37.283', 2.15, 1, 'false', 2085581392);
insert into GAMBIT_RESULTS values ( 2085581468, 'Granada','2020-03-07 17:41:37.283', 2.45, 0, 'false', 2085581452);
insert into GAMBIT_RESULTS values ( 2085581469, 'Empate','2020-03-07 17:41:37.284', 2.95, 1, 'false', 2085581452);
insert into GAMBIT_RESULTS values ( 2085581470, 'Valladolid','2020-03-07 17:41:37.284', 3.1, 2, 'false', 2085581452);
insert into GAMBIT_RESULTS values ( 2085581459, 'Altas 1.5','2020-03-07 17:41:37.284', 1.48, 0, 'false', 2085581447);
insert into GAMBIT_RESULTS values ( 2085581460, 'Bajas 1.5','2020-03-07 17:41:37.284', 2.5, 1, 'false', 2085581447);
insert into GAMBIT_RESULTS values ( 2085581612, 'Real Sociedad','2020-03-07 17:41:37.284', 1.95, 0, 'false', 2085581597);
insert into GAMBIT_RESULTS values ( 2085581613, 'Empate','2020-03-07 17:41:37.284', 3.6, 1, 'false', 2085581597);
insert into GAMBIT_RESULTS values ( 2085581614, 'Valencia','2020-03-07 17:41:37.285', 3.6, 2, 'false', 2085581597);
insert into GAMBIT_RESULTS values ( 2085581606, 'Altas 2.5','2020-03-07 17:41:37.285', 1.8, 0, 'false', 2085581593);
insert into GAMBIT_RESULTS values ( 2085581607, 'Bajas 2.5','2020-03-07 17:41:37.285', 1.95, 1, 'false', 2085581593);
insert into GAMBIT_RESULTS values ( 2085582577, 'Real Madrid','2020-03-07 17:41:37.285', 2.25, 0, 'false', 2085582560);
insert into GAMBIT_RESULTS values ( 2085582578, 'Empate','2020-03-07 17:41:37.286', 3.6, 1, 'false', 2085582560);
insert into GAMBIT_RESULTS values ( 2085582579, 'Barcelona','2020-03-07 17:41:37.286', 2.85, 2, 'false', 2085582560);
insert into GAMBIT_RESULTS values ( 2085582793, 'Barcelona','2020-03-07 17:41:37.286', 1.2, 0, 'false', 2085582778);
insert into GAMBIT_RESULTS values ( 2085582794, 'Empate','2020-03-07 17:41:37.286', 6.25, 1, 'false', 2085582778);
insert into GAMBIT_RESULTS values ( 2085582795, 'Eibar','2020-03-07 17:41:37.286', 13.0, 2, 'false', 2085582778);
insert into GAMBIT_RESULTS values ( 2085582789, 'Altas 3.5','2020-03-07 17:41:37.287', 1.95, 0, 'false', 2085582775);
insert into GAMBIT_RESULTS values ( 2085582790, 'Bajas 3.5','2020-03-07 17:41:37.287', 1.8, 1, 'false', 2085582775);
insert into GAMBIT_RESULTS values ( 2085583650, 'Valencia','2020-03-07 17:41:37.287', 3.0, 0, 'false', 2085583622);
insert into GAMBIT_RESULTS values ( 2085583651, 'Empate','2020-03-07 17:41:37.287', 3.05, 1, 'false', 2085583622);
insert into GAMBIT_RESULTS values ( 2085583652, 'Atlético','2020-03-07 17:41:37.287', 2.45, 2, 'false', 2085583622);
insert into GAMBIT_RESULTS values ( 2085583644, 'Altas 2.5','2020-03-07 17:41:37.288', 2.4, 0, 'false', 2085583614);
insert into GAMBIT_RESULTS values ( 2085583645, 'Bajas 2.5','2020-03-07 17:41:37.288', 1.53, 1, 'false', 2085583614);
insert into GAMBIT_RESULTS values ( 2085584717, 'Alavés','2020-03-07 17:41:37.288', 2.95, 0, 'false', 2085584702);
insert into GAMBIT_RESULTS values ( 2085584718, 'Empate','2020-03-07 17:41:37.288', 2.85, 1, 'false', 2085584702);
insert into GAMBIT_RESULTS values ( 2085584719, 'Athletic','2020-03-07 17:41:37.289', 2.65, 2, 'false', 2085584702);
insert into GAMBIT_RESULTS values ( 2085584709, 'Altas 1.5','2020-03-07 17:41:37.289', 1.55, 0, 'false', 2085584697);
insert into GAMBIT_RESULTS values ( 2085584710, 'Bajas 1.5','2020-03-07 17:41:37.289', 2.35, 1, 'false', 2085584697);
insert into GAMBIT_RESULTS values ( 2085585233, 'Atlético','2020-03-07 17:41:37.289', 1.62, 0, 'false', 2085585218);
insert into GAMBIT_RESULTS values ( 2085585234, 'Empate','2020-03-07 17:41:37.289', 3.6, 1, 'false', 2085585218);
insert into GAMBIT_RESULTS values ( 2085585235, 'Villarreal','2020-03-07 17:41:37.290', 5.75, 2, 'false', 2085585218);
insert into GAMBIT_RESULTS values ( 2085585227, 'Altas 2.5','2020-03-07 17:41:37.290', 2.0, 0, 'false', 2085585214);
insert into GAMBIT_RESULTS values ( 2085585228, 'Bajas 2.5','2020-03-07 17:41:37.290', 1.75, 1, 'false', 2085585214);
insert into GAMBIT_RESULTS values ( 2085585266, 'Levante','2020-03-07 17:41:37.290', 5.75, 0, 'false', 2085585251);
insert into GAMBIT_RESULTS values ( 2085585267, 'Empate','2020-03-07 17:41:37.290', 4.75, 1, 'false', 2085585251);
insert into GAMBIT_RESULTS values ( 2085585268, 'Real Madrid','2020-03-07 17:41:37.291', 1.45, 2, 'false', 2085585251);
insert into GAMBIT_RESULTS values ( 2085585262, 'Altas 3.5','2020-03-07 17:41:37.291', 2.05, 0, 'false', 2085585248);
insert into GAMBIT_RESULTS values ( 2085585263, 'Bajas 3.5','2020-03-07 17:41:37.291', 1.72, 1, 'false', 2085585248);
insert into GAMBIT_RESULTS values ( 2085585392, 'Getafe','2020-03-07 17:41:37.292', 2.55, 0, 'false', 2085585377);
insert into GAMBIT_RESULTS values ( 2085585393, 'Empate','2020-03-07 17:41:37.292', 3.05, 1, 'false', 2085585377);
insert into GAMBIT_RESULTS values ( 2085585394, 'Sevilla','2020-03-07 17:41:37.292', 2.85, 2, 'false', 2085585377);
insert into GAMBIT_RESULTS values ( 2085585386, 'Altas 2.5','2020-03-07 17:41:37.292', 2.35, 0, 'false', 2085585373);
insert into GAMBIT_RESULTS values ( 2085585387, 'Bajas 2.5','2020-03-07 17:41:37.292', 1.55, 1, 'false', 2085585373);
insert into GAMBIT_RESULTS values ( 2085585440, 'Celta','2020-03-07 17:41:37.293', 2.0, 0, 'false', 2085585414);
insert into GAMBIT_RESULTS values ( 2085585441, 'Empate','2020-03-07 17:41:37.293', 3.15, 1, 'false', 2085585414);
insert into GAMBIT_RESULTS values ( 2085585442, 'Leganés','2020-03-07 17:41:37.293', 4.0, 2, 'false', 2085585414);
insert into GAMBIT_RESULTS values ( 2085585434, 'Altas 2.5','2020-03-07 17:41:37.293', 2.35, 0, 'false', 2085585410);
insert into GAMBIT_RESULTS values ( 2085585435, 'Bajas 2.5','2020-03-07 17:41:37.293', 1.55, 1, 'false', 2085585410);
insert into GAMBIT_RESULTS values ( 2085585887, 'Osasuna','2020-03-07 17:41:37.294', 1.95, 0, 'false', 2085585869);
insert into GAMBIT_RESULTS values ( 2085585888, 'Empate','2020-03-07 17:41:37.294', 3.3, 1, 'false', 2085585869);
insert into GAMBIT_RESULTS values ( 2085585889, 'Granada','2020-03-07 17:41:37.294', 4.0, 2, 'false', 2085585869);
insert into GAMBIT_RESULTS values ( 2085585881, 'Altas 2.5','2020-03-07 17:41:37.294', 2.25, 0, 'false', 2085585865);
insert into GAMBIT_RESULTS values ( 2085585882, 'Bajas 2.5','2020-03-07 17:41:37.295', 1.6, 1, 'false', 2085585865);
insert into GAMBIT_RESULTS values ( 2085587292, 'Valladolid','2020-03-07 17:41:37.295', 2.55, 0, 'false', 2085587276);
insert into GAMBIT_RESULTS values ( 2085587293, 'Empate','2020-03-07 17:41:37.295', 2.95, 1, 'false', 2085587276);
insert into GAMBIT_RESULTS values ( 2085587294, 'Espanyol','2020-03-07 17:41:37.295', 2.95, 2, 'false', 2085587276);

insert into GAMBIT_RESULTS values ( 2599201059, 'Atlético San Luis','2020-03-07 17:42:23.792', 2.85, 0, 'false', 2599200576);
insert into GAMBIT_RESULTS values ( 2599201060, 'Empate','2020-03-07 17:42:23.793', 3.4, 1, 'false', 2599200576);
insert into GAMBIT_RESULTS values ( 2599201061, 'Club León','2020-03-07 17:42:23.793', 2.35, 2, 'false', 2599200576);
insert into GAMBIT_RESULTS values ( 2599323171, 'Monarcas Morelia','2020-03-07 17:42:23.794', 2.0, 0, 'false', 2599322704);
insert into GAMBIT_RESULTS values ( 2599323172, 'Empate','2020-03-07 17:42:23.794', 3.35, 1, 'false', 2599322704);
insert into GAMBIT_RESULTS values ( 2599323173, 'Club Tijuana','2020-03-07 17:42:23.794', 3.6, 2, 'false', 2599322704);
insert into GAMBIT_RESULTS values ( 2601345415, 'Pachuca','2020-03-07 17:42:23.794', 1.55, 0, 'false', 2601344927);
insert into GAMBIT_RESULTS values ( 2601345416, 'Empate','2020-03-07 17:42:23.795', 4.0, 1, 'false', 2601344927);
insert into GAMBIT_RESULTS values ( 2601345417, 'Puebla','2020-03-07 17:42:23.795', 5.75, 2, 'false', 2601344927);
insert into GAMBIT_RESULTS values ( 2603378673, 'Toluca','2020-03-07 17:42:23.795', 2.35, 0, 'false', 2603378214);
insert into GAMBIT_RESULTS values ( 2603378674, 'Empate','2020-03-07 17:42:23.795', 3.3, 1, 'false', 2603378214);
insert into GAMBIT_RESULTS values ( 2603378675, 'Pumas UNAM','2020-03-07 17:42:23.796', 2.95, 2, 'false', 2603378214);
insert into GAMBIT_RESULTS values ( 2601976460, 'América','2020-03-07 17:42:23.796', 1.5, 0, 'false', 2601975977);
insert into GAMBIT_RESULTS values ( 2601976461, 'Empate','2020-03-07 17:42:23.796', 4.0, 1, 'false', 2601975977);
insert into GAMBIT_RESULTS values ( 2601976462, 'Atlas','2020-03-07 17:42:23.797', 6.25, 2, 'false', 2601975977);
insert into GAMBIT_RESULTS values ( 2601976992, 'Monterrey','2020-03-07 17:42:23.797', 1.4, 0, 'false', 2601976557);
insert into GAMBIT_RESULTS values ( 2601976993, 'Empate','2020-03-07 17:42:23.797', 4.4, 1, 'false', 2601976557);
insert into GAMBIT_RESULTS values ( 2601976994, 'FC Juárez','2020-03-07 17:42:23.797', 7.25, 2, 'false', 2601976557);
insert into GAMBIT_RESULTS values ( 2602124190, 'Guadalajara','2020-03-07 17:42:23.798', 2.55, 0, 'false', 2602123739);
insert into GAMBIT_RESULTS values ( 2602124191, 'Empate','2020-03-07 17:42:23.798', 3.15, 1, 'false', 2602123739);
insert into GAMBIT_RESULTS values ( 2602124192, 'Cruz Azul','2020-03-07 17:42:23.798', 2.75, 2, 'false', 2602123739);
insert into GAMBIT_RESULTS values ( 2603826217, 'Club Necaxa','2020-03-07 17:42:23.799', 2.3, 0, 'false', 2603825806);
insert into GAMBIT_RESULTS values ( 2603826218, 'Empate','2020-03-07 17:42:23.799', 3.4, 1, 'false', 2603825806);
insert into GAMBIT_RESULTS values ( 2603826219, 'Querétaro','2020-03-07 17:42:23.799', 2.95, 2, 'false', 2603825806);
insert into GAMBIT_RESULTS values ( 2603826706, 'Santos Laguna','2020-03-07 17:42:23.799', 2.1, 0, 'false', 2603826279);
insert into GAMBIT_RESULTS values ( 2603826707, 'Empate','2020-03-07 17:42:23.800', 3.5, 1, 'false', 2603826279);
insert into GAMBIT_RESULTS values ( 2603826708, 'Tigres UANL','2020-03-07 17:42:23.800', 3.3, 2, 'false', 2603826279);
insert into GAMBIT_RESULTS values ( 2614257203, 'Atlas','2020-03-07 17:42:23.800', 2.75, 0, 'false', 2614256726);
insert into GAMBIT_RESULTS values ( 2614257204, 'Empate','2020-03-07 17:42:23.801', 3.35, 1, 'false', 2614256726);
insert into GAMBIT_RESULTS values ( 2614257205, 'Pachuca','2020-03-07 17:42:23.801', 2.45, 2, 'false', 2614256726);
insert into GAMBIT_RESULTS values ( 2614420153, 'Puebla','2020-03-07 17:42:23.801', 2.2, 0, 'false', 2614419619);
insert into GAMBIT_RESULTS values ( 2614420154, 'Empate','2020-03-07 17:42:23.801', 3.4, 1, 'false', 2614419619);
insert into GAMBIT_RESULTS values ( 2614420155, 'Toluca','2020-03-07 17:42:23.802', 3.15, 2, 'false', 2614419619);
insert into GAMBIT_RESULTS values ( 2616467304, 'Club León','2020-03-07 17:42:23.802', 1.75, 0, 'false', 2616466851);
insert into GAMBIT_RESULTS values ( 2616467305, 'Empate','2020-03-07 17:42:23.802', 3.9, 1, 'false', 2616466851);
insert into GAMBIT_RESULTS values ( 2616467306, 'Club Necaxa','2020-03-07 17:42:23.802', 4.2, 2, 'false', 2616466851);
insert into GAMBIT_RESULTS values ( 2617109559, 'Cruz Azul','2020-03-07 17:42:23.803', 2.25, 0, 'false', 2617109136);
insert into GAMBIT_RESULTS values ( 2617109560, 'Empate','2020-03-07 17:42:23.803', 3.4, 1, 'false', 2617109136);
insert into GAMBIT_RESULTS values ( 2617109561, 'Tigres UANL','2020-03-07 17:42:23.803', 3.05, 2, 'false', 2617109136);
insert into GAMBIT_RESULTS values ( 2618446921, 'Pumas UNAM','2020-03-07 17:42:23.803', 1.85, 0, 'false', 2618446477);
insert into GAMBIT_RESULTS values ( 2618446922, 'Empate','2020-03-07 17:42:23.803', 3.7, 1, 'false', 2618446477);
insert into GAMBIT_RESULTS values ( 2618446923, 'Monarcas Morelia','2020-03-07 17:42:23.804', 3.9, 2, 'false', 2618446477);
insert into GAMBIT_RESULTS values ( 2619360202, 'FC Juárez','2020-03-07 17:42:23.804', 3.05, 0, 'false', 2619359753);
insert into GAMBIT_RESULTS values ( 2619360203, 'Empate','2020-03-07 17:42:23.804', 3.7, 1, 'false', 2619359753);
insert into GAMBIT_RESULTS values ( 2619360204, 'Santos Laguna','2020-03-07 17:42:23.804', 2.15, 2, 'false', 2619359753);

*/


/*
select c.nodeid, c.name, 
	l.nodeid, l.name,
	e.nodeid, e.name, e.startdate,
	g.name, g.priority,
	gr.name, gr.createtime,gr.odd,
	ga.createtime, ga.odd, ga.parentnodeid
from countries c
join leagues l on ( c.nodeid=l.parentnodeid)
join events e on  ( l.nodeid=e.parentnodeid)
join games g on (e.nodeid=g.parentnodeid)
join gambit_results gr on (g.nodeid=gr.parentnodeid)
join gambit ga on (gr.nodeid=ga.parentnodeid)
where c.countrycode='MX'*/