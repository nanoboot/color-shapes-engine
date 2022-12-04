CREATE TABLE shape(
    id TEXT PRIMARY KEY,
    height INTEGER NOT NULL CHECK(typeof(height)='integer' AND height>=1 AND height<=32),
    width INTEGER NOT NULL CHECK(typeof(width)='integer' AND width>=1 AND height<=32),
    description TEXT CHECK(typeof(description)='text')
);

CREATE TABLE board_composition(
    id TEXT PRIMARY KEY ,
    grid_probability INTEGER NOT NULL CHECK(typeof(grid_probability)='integer' AND grid_probability>=0 AND grid_probability<=100),
    grid_count INTEGER NOT NULL CHECK(typeof(grid_count)='integer' AND grid_count>=0 AND grid_count<=16),
    wall_probability INTEGER NOT NULL CHECK(typeof(wall_probability)='integer' AND wall_probability>=0 AND wall_probability<=100),
    wall_count INTEGER NOT NULL CHECK(typeof(wall_count)='integer' AND wall_count>=0 AND wall_count<=16),
    shape_id TEXT,
    FOREIGN KEY(shape_id) REFERENCES shape(id)
);

CREATE TABLE colour_frequencies(
    id TEXT PRIMARY KEY,
    colour1_frequency INTEGER NOT NULL CHECK(typeof(colour1_frequency)='integer' AND colour1_frequency>=0 AND colour1_frequency<=100),
    colour2_frequency INTEGER NOT NULL CHECK(typeof(colour2_frequency)='integer' AND colour2_frequency>=0 AND colour2_frequency<=100),
    colour3_frequency INTEGER NOT NULL CHECK(typeof(colour3_frequency)='integer' AND colour3_frequency>=0 AND colour3_frequency<=100),
    colour4_frequency INTEGER NOT NULL CHECK(typeof(colour4_frequency)='integer' AND colour4_frequency>=0 AND colour4_frequency<=100),
    colour5_frequency INTEGER NOT NULL CHECK(typeof(colour5_frequency)='integer' AND colour5_frequency>=0 AND colour5_frequency<=100),
    colour6_frequency INTEGER NOT NULL CHECK(typeof(colour6_frequency)='integer' AND colour6_frequency>=0 AND colour6_frequency<=100),
    colour7_frequency INTEGER NOT NULL CHECK(typeof(colour7_frequency)='integer' AND colour7_frequency>=0 AND colour7_frequency<=100),
    colour8_frequency INTEGER NOT NULL CHECK(typeof(colour8_frequency)='integer' AND colour8_frequency>=0 AND colour8_frequency<=100),
    colour9_frequency INTEGER NOT NULL CHECK(typeof(colour9_frequency)='integer' AND colour9_frequency>=0 AND colour9_frequency<=100),
    colour10_frequency INTEGER NOT NULL CHECK(typeof(colour10_frequency)='integer' AND colour10_frequency>=0 AND colour10_frequency<=100),
    colour11_frequency INTEGER NOT NULL CHECK(typeof(colour11_frequency)='integer' AND colour11_frequency>=0 AND colour11_frequency<=100),
    colour12_frequency INTEGER NOT NULL CHECK(typeof(colour12_frequency)='integer' AND colour12_frequency>=0 AND colour12_frequency<=100),
    colour13_frequency INTEGER NOT NULL CHECK(typeof(colour13_frequency)='integer' AND colour13_frequency>=0 AND colour13_frequency<=100),
    colour14_frequency INTEGER NOT NULL CHECK(typeof(colour14_frequency)='integer' AND colour14_frequency>=0 AND colour14_frequency<=100),
    colour15_frequency INTEGER NOT NULL CHECK(typeof(colour15_frequency)='integer' AND colour15_frequency>=0 AND colour15_frequency<=100),
    colour16_frequency INTEGER NOT NULL CHECK(typeof(colour16_frequency)='integer' AND colour16_frequency>=0 AND colour16_frequency<=100)
);

CREATE TABLE value_frequencies(
    id TEXT PRIMARY KEY,
    minus2_frequency INTEGER NOT NULL CHECK(typeof(minus2_frequency)='integer' AND minus2_frequency>=0 AND minus2_frequency<=100),
    minus1_frequency INTEGER NOT NULL CHECK(typeof(minus1_frequency)='integer' AND minus1_frequency>=0 AND minus1_frequency<=100),
    zero_frequency INTEGER NOT NULL CHECK(typeof(zero_frequency)='integer' AND zero_frequency>=0 AND zero_frequency<=100),
    plus1_frequency INTEGER NOT NULL CHECK(typeof(plus1_frequency)='integer' AND plus1_frequency>=0 AND plus1_frequency<=100),
    plus2_frequency INTEGER NOT NULL CHECK(typeof(plus2_frequency)='integer' AND plus2_frequency>=0 AND plus2_frequency<=100)
);

CREATE TABLE ball_factory_composition(
    id TEXT PRIMARY KEY,    
    coloured_ball_frequency INTEGER NOT NULL CHECK(typeof(coloured_ball_frequency)='integer' AND coloured_ball_frequency>=0 AND coloured_ball_frequency<=100),
    joker_ball_frequency INTEGER NOT NULL CHECK(typeof(joker_ball_frequency)='integer' AND joker_ball_frequency>=0 AND joker_ball_frequency<=100),
    automatic_bomb_frequency INTEGER CHECK(typeof(automatic_bomb_frequency)='integer' AND automatic_bomb_frequency>=0 AND automatic_bomb_frequency<=100),
    manual_bomb_frequency INTEGER CHECK(typeof(manual_bomb_frequency)='integer' AND manual_bomb_frequency>=0 AND manual_bomb_frequency<=100),
    paint_bomb_frequency INTEGER CHECK(typeof(manual_bomb_frequency)='integer' AND manual_bomb_frequency>=0 AND manual_bomb_frequency<=100),
    moveable_ball_probability INTEGER NOT NULL CHECK(typeof(moveable_ball_probability)='integer' AND moveable_ball_probability>=0 AND moveable_ball_probability<=100),
    breakable_ball_probability INTEGER NOT NULL CHECK(typeof(breakable_ball_probability)='integer' AND breakable_ball_probability>=0 AND breakable_ball_probability<=100),
    colour_frequencies_id TEXT NOT NULL CHECK(typeof(colour_frequencies_id)='TEXT'),
    value_frequencies_id TEXT NOT NULL CHECK(typeof(value_frequencies_id)='TEXT'),
    FOREIGN KEY(colour_frequency_id) REFERENCES colour_frequency(id),
    FOREIGN KEY(value_frequencies_id) REFERENCES value_frequencies(id)
);

CREATE TABLE ball_thrower_composition (
    id TEXT PRIMARY KEY CHECK(typeof(id)='TEXT'),
    start_ball_count INTEGER CHECK(typeof(start_ball_count)='integer' AND start_ball_count>=1 AND start_ball_count<=16),
    next_ball_count INTEGER CHECK(typeof(next_ball_count)='integer' AND next_ball_count>=1 AND next_ball_count<=9),
    show_next_ball_positions INTEGER CHECK(typeof(show_next_ball_positions)='integer' AND show_next_ball_positions IN(0,1))
);

CREATE TABLE shape_finder_composition (
    id TEXT PRIMARY KEY CHECK(typeof(id)='TEXT'),
    exploding_shape_type TEXT,
    minimum_size INTEGER CHECK((minimum_size>=2 AND minimum_size<=32) OR minimum_size=0),
    custom_exploding_shape_id INTEGER,
    FOREIGN KEY(custom_exploding_shape_id) REFERENCES shape(id)
);

CREATE TABLE other_composition(
    id TEXT PRIMARY KEY CHECK(typeof(id)='TEXT'),
    allowed_step_back INTEGER CHECK(typeof(allowed_step_back)='integer' AND allowed_step_back IN(0,1)),
    free_mode INTEGER CHECK(typeof(free_mode)='integer' AND free_mode IN(0,1)),
    trainer INTEGER CHECK(typeof(trainer)='integer' AND trainer IN(0,1))
);

CREATE TABLE game_composition(
    id TEXT PRIMARY KEY,
    board_composition_id TEXT,
    ball_factory_composition_id TEXT,
    ball_thrower_composition_id TEXT,
    shape_finder_composition_id TEXT,
    other_composition_id TEXT,
    FOREIGN KEY(board_composition_id) REFERENCES board_composition(id),
    FOREIGN KEY(ball_factory_composition_id) REFERENCES ball_factory_composition(id),
    FOREIGN KEY(ball_thrower_composition_id) REFERENCES ball_thrower_composition(id),
    FOREIGN KEY(shape_finder_composition_id) REFERENCES shape_finder_composition(id),
    FOREIGN KEY(other_composition_id) REFERENCES other_composition(id)
);


CREATE TABLE player(
    id TEXT PRIMARY KEY CHECK(typeof(id)='TEXT'),
    nick TEXT NOT NULL UNIQUE CHECK(typeof(nick)='text'),
    password TEXT NOT NULL CHECK(typeof(password)='text'),
    created_on INTEGER NOT NULL,
    language_id INTEGER NOT NULL,
    skin INTEGER NOT NULL CHECK(typeof(skin)='integer' AND skin>=1 AND skin <=16),
    zoom INTEGER NOT NULL CHECK(typeof(zoom)='integer' AND zoom>=50),
    ball_lighting_id INTEGER NOT NULL,
    show_lines_around_ball INTEGER DEFAULT 0 CHECK(typeof(show_lines_around_ball)='integer' AND show_lines_around_ball IN (0,1)),
    show_next_balls INTEGER DEFAULT 1 CHECK(typeof(show_next_balls)='integer' AND show_next_balls IN (0,1)),
    show_where_a_ball_can_be_moved INTEGER DEFAULT 0 CHECK(typeof(show_where_a_ball_can_be_moved)='integer' AND show_where_a_ball_can_be_moved IN (0,1)),
    highlight_cells_after_ball_exploded INTEGER DEFAULT 1 CHECK(typeof(highlight_cells_after_ball_exploded)='integer' AND highlight_cells_after_ball_exploded IN (0,1)),
    ball_move_effect_id INTEGER NOT NULL,
    name TEXT,
    surname TEXT,
    sex TEXT DEFAULT 'unknown' CHECK(typeof(sex)='text' AND sex IN('man','woman','unknown')),
    date_of_birth TEXT,
    time_zone_id INTEGER NOT NULL,
    FOREIGN KEY(player_created_universal_date_time_id) REFERENCES universal_date_time(id),
    FOREIGN KEY(language_id) REFERENCES language(id),
    FOREIGN KEY(ball_lighting_id ) REFERENCES ball_lighting(id),
    FOREIGN KEY(ball_move_effect_id) REFERENCES ball_move_effect(id),
    FOREIGN KEY(time_zone_id) REFERENCES time_zone(id));


CREATE TABLE player_detail(
    id TEXT PRIMARY KEY CHECK(typeof(id)='TEXT'),
    player_id TEXT NOT NULL,
    password TEXT NOT NULL CHECK(typeof(password)='text'),
    FOREIGN KEY(player_id) REFERENCES player(id)
);









CREATE TABLE language(
    id INTEGER PRIMARY KEY AUTOINCREMENT CHECK(typeof(id)='integer'),
    code TEXT NOT NULL CHECK(typeof(code)='text'),
    language_name_original TEXT NOT NULL CHECK(typeof(language_name_original)='text'),
    language_name_in_english TEXT NOT NULL CHECK(typeof(language_name_in_english)='text'));

CREATE TABLE text_constant(
    id INTEGER PRIMARY KEY AUTOINCREMENT CHECK(typeof(id)='integer'),
    text_constant_type_id INTEGER,
    language_id INTEGER NOT NULL,
    value TEXT NOT NULL CHECK(typeof(value)='text'),
    FOREIGN KEY(text_constant_type_id) REFERENCES text_constant_type(id),
    FOREIGN KEY(language_id) REFERENCES language(id));

CREATE TABLE text_constant_type(
    id INTEGER PRIMARY KEY AUTOINCREMENT CHECK(typeof(id)='integer'),
    description TEXT CHECK(typeof(description)='text'));

CREATE TABLE ball_lighting(
    id INTEGER PRIMARY KEY AUTOINCREMENT CHECK(typeof(id)='integer'),
    name TEXT NOT NULL CHECK(typeof(name)='text' AND name IN('none','above','ahead')));

CREATE TABLE ball_move_effect(
    id INTEGER PRIMARY KEY CHECK(typeof(id)='integer'),
    name TEXT NOT NULL CHECK(typeof(name)='text' AND name IN('no','arrow','highlight')));

CREATE TABLE time_zone(
    id INTEGER PRIMARY KEY AUTOINCREMENT CHECK(typeof(id)='integer'),
    name TEXT NOT NULL CHECK(typeof(name)='text'));

CREATE TABLE game(
    id INTEGER PRIMARY KEY AUTOINCREMENT CHECK(typeof(id)='integer'),
    session_id INTEGER,
    player_id INTEGER,
    game_composition_id INTEGER,
    result_score INTEGER CHECK(typeof(result_score)='integer'),
    pseudo_random_generator_id INTEGER,
    FOREIGN KEY(session_id) REFERENCES session(id),
    FOREIGN KEY(player_id) REFERENCES player(id),
    FOREIGN KEY(game_composition_id) REFERENCES game_composition(id),
    FOREIGN KEY(pseudo_random_generator_id) REFERENCES pseudo_random_generator(id));

CREATE TABLE session(
    id INTEGER PRIMARY KEY AUTOINCREMENT CHECK(typeof(id)='integer'),
    start_universal_date_time_id INTEGER,
    end_universal_date_time_id INTEGER,
    FOREIGN KEY(start_universal_date_time_id) REFERENCES universal_date_time(id),
    FOREIGN KEY(end_universal_date_time_id) REFERENCES universal_date_time(id));

CREATE TABLE application_session(
    id INTEGER PRIMARY KEY AUTOINCREMENT CHECK(typeof(id)='integer'),
    session_id INTEGER,
    FOREIGN KEY(session_id) REFERENCES session(id));

CREATE TABLE application(
    id INTEGER PRIMARY KEY AUTOINCREMENT CHECK(id=1 and typeof(id)='integer'),
    installation_unique_number INTEGER NOT NULL CHECK(typeof(installation_unique_number)='integer'),
    first_launch_universal_date_time_id INTEGER,
    automatically_logged_in_player_id INTEGER CHECK(typeof(automatically_logged_in_player_id)='integer' AND automatically_logged_in_player_id>=0),
    before_login_language_id INTEGER,
    before_login_colour_skin INTEGER NOT NULL CHECK(typeof(before_login_colour_skin)='integer' AND before_login_colour_skin>=1 AND before_login_colour_skin <=16),
    before_login_zoom INTEGER NOT NULL CHECK(typeof(before_login_zoom)='integer' AND before_login_zoom>=50),
    FOREIGN KEY(first_launch_universal_date_time_id) REFERENCES universal_date_time(id),
    --FOREIGN KEY(automatically_logged_in_player_id) REFERENCES player(id),
    FOREIGN KEY(before_login_language_id) REFERENCES language(id));

CREATE TABLE player_session(
    id INTEGER PRIMARY KEY AUTOINCREMENT CHECK(typeof(id)='integer'),
    session_id INTEGER,
    player_id INTEGER,
    FOREIGN KEY(player_id) REFERENCES player(id),
    FOREIGN KEY(session_id) REFERENCES session(id));

CREATE TABLE hole(
    id INTEGER PRIMARY KEY AUTOINCREMENT CHECK(typeof(id)='integer'),
    shape_id INTEGER,
    row INTEGER NOT NULL CHECK(typeof(row)='integer' AND row>=1 AND row<=32),
    column INTEGER NOT NULL CHECK(typeof(column)='integer' AND column>=1 AND column<=32),
    FOREIGN KEY(shape_id) REFERENCES shape(id));

CREATE TABLE pseudo_random_generator(
    id INTEGER PRIMARY KEY AUTOINCREMENT CHECK(typeof(id)='integer'),
    magic_number INTEGER CHECK(typeof(magic_number)='integer' AND magic_number>=0),
    magic_universal_date_time_id INTEGER,
    FOREIGN KEY(magic_universal_date_time_id) REFERENCES universal_date_time(id));

CREATE TABLE game_action(
    id INTEGER PRIMARY KEY AUTOINCREMENT CHECK(typeof(id)='integer'),
    game_id INTEGER,
    universal_date_time_id INTEGER,
    activated_row INTEGER CHECK(typeof(activated_row)='integer' AND activated_row>=1 AND activated_row<=32),
    activated_column INTEGER CHECK(typeof(activated_column)='integer' AND activated_column>=1 AND activated_column<=32),
    FOREIGN KEY(game_id) REFERENCES game(id),
    FOREIGN KEY(universal_date_time_id) REFERENCES universal_date_time(id));