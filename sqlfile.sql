create table recipe.bookmark (
  user_id integer not null
  , post_id integer not null
  , created_at timestamp(6) without time zone default CURRENT_TIMESTAMP
  , primary key (user_id, post_id)
);
create table recipe."comment" (
  comment_id serial not null
  , post_id integer
  , user_id integer
  , comment_detail text not null
  , primary key (comment_id)
);
create table recipe.m_category (
  category_id serial not null
  , category_name character varying(100) not null
  , primary key (category_id)
);
create table recipe.m_user (
  user_id serial not null
  , email character varying(150) not null
  , password_hash text not null
  , role character varying(50) default 'USER'
  , is_active boolean default true
  , created_at timestamp(6) without time zone default CURRENT_TIMESTAMP
  , primary key (user_id)
);
create table recipe.material (
  material_id serial not null
  , name character varying(100) not null
  , primary key (material_id)
);
create table recipe.notification (
  notification_id serial not null
  , user_id integer
  , message text
  , is_read boolean default false
  , created_at timestamp(6) without time zone default CURRENT_TIMESTAMP
  , primary key (notification_id)
);
create table recipe.post (
  post_id serial not null
  , user_id integer
  , image text
  , video_url text
  , make_time interval
  , cost numeric(10, 2)
  , season_id integer
  , trigger text
  , like_number integer default 0
  , view_count integer default 0
  , primary key (post_id)
);
create table recipe.post_category (
  post_id integer not null
  , category_id integer not null
  , primary key (post_id, category_id)
);
create table recipe.post_material (
  post_id integer not null
  , material_id integer not null
  , quantity character varying(50)
  , primary key (post_id, material_id)
);
create table recipe.post_rating (
  post_id integer not null
  , user_id integer not null
  , rating integer
  , comment text
  , created_at timestamp(6) without time zone default CURRENT_TIMESTAMP
  , primary key (post_id, user_id)
);
create table recipe.post_recipe_step (
  step_id serial not null
  , post_id integer
  , step_number integer
  , recipe_comment text
  , recipe_image text
  , recipe_video text
  , primary key (step_id)
);
create table recipe.post_tag (
  post_id integer not null
  , tag_id integer not null
  , primary key (post_id, tag_id)
);
create table recipe.season (
  season_id serial not null
  , season_name character varying(100) not null
  , primary key (season_id)
);
create table recipe.tag (
  tag_id serial not null
  , name character varying(50)
  , primary key (tag_id)
);
create table recipe.tiktok_users (
  id serial not null
  , first_name character varying(100)
  , last_name character varying(100)
  , full_name character varying(200)
  , nickname character varying(100)
  , avatar text
  , bio text
  , tick boolean default false
  , followings_count integer default 0
  , followers_count integer default 0
  , likes_count integer default 0
  , website_url text
  , facebook_url text
  , youtube_url text
  , twitter_url text
  , instagram_url text
  , created_at timestamp(6) without time zone default CURRENT_TIMESTAMP
  , updated_at timestamp(6) without time zone default CURRENT_TIMESTAMP
  , primary key (id)
);
create table recipe.user_info (
  user_id serial not null
  , full_name character varying(100)
  , nick_name character varying(100)
  , avatar_url text
  , birthday date
  , tick boolean default false
  , following integer default 0
  , followed integer default 0
  , primary key (user_id)
);
