public class CollisionHandler {

    GamePanel p;

    public CollisionHandler(GamePanel p){
        this.p = p;
    }

    public void tileChecker(Player pl){
        int player_left_x = pl.x_position + pl.solid_size.x;
        int player_right_x = player_left_x + pl.solid_size.width;
        int player_up_y = pl.y_position + pl.solid_size.y;
        int player_down_y = player_up_y + p.block_size;

        int left_column = player_left_x/p.block_size;
        int right_column = player_right_x/p.block_size;
        int up_row = player_up_y/p.block_size;
        int down_row = player_down_y/p.block_size;

        int tile1,tile2;

        switch (pl.direction){
            case 1:
                up_row = (player_up_y - pl.change_position)/p.block_size;
                tile1 = p.tiles.map_tile_number[left_column][up_row];
                tile2 = p.tiles.map_tile_number[right_column][up_row];

                if (p.tiles.t[tile1].collision || p.tiles.t[tile2].collision){
                    pl.player_collision = true;
                }
                break;
            case 2:
                down_row = (player_down_y + pl.change_position)/p.block_size;
                tile1 = p.tiles.map_tile_number[left_column][down_row];
                tile2 = p.tiles.map_tile_number[right_column][down_row];

                if (p.tiles.t[tile1].collision || p.tiles.t[tile2].collision){
                    pl.player_collision = true;
                }
                break;
            case 3:
                left_column = (player_left_x - pl.change_position)/p.block_size;
                tile1 = p.tiles.map_tile_number[left_column][up_row];
                tile2 = p.tiles.map_tile_number[left_column][down_row];

                if (p.tiles.t[tile1].collision || p.tiles.t[tile2].collision){
                    pl.player_collision = true;
                }
                break;
            case 4:
                right_column = (player_right_x + pl.change_position)/p.block_size;
                tile1 = p.tiles.map_tile_number[right_column][up_row];
                tile2 = p.tiles.map_tile_number[right_column][down_row];

                if (p.tiles.t[tile1].collision || p.tiles.t[tile2].collision){
                    pl.player_collision = true;
                }
                break;
        }

    }
}