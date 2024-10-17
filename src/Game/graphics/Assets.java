package Game.graphics;

import Game.tiles.logos.FlyEmirates1;

import java.awt.image.BufferedImage;

public class Assets {

    private static final int width=128;
    private static final int height=128;

    public static BufferedImage player,trophy;
    public static BufferedImage player_right,player_left,player_up,player_down;
    public static BufferedImage player_rightUP,player_leftUP,player_rightDOWN,player_leftDOWN;
    public static BufferedImage grass, grassFinishLine, gravel, tyreBarrierWallUp, tyreBarrierWallRight,tyreBarrierWallDown,tyreBarrierWallLeft;
    public static BufferedImage asphalt,finishLane,Grid1,Grid2, safetyCar,astroturf,astroturfFinishLine;
    public static BufferedImage grassCutTheCorner, gravelCutTheCorner;

    public static BufferedImage asphalt_kerb_red_upRight, asphalt_kerb_red_downRight,asphalt_kerb_red_upLeft,asphalt_kerb_red_downLeft;
    public static BufferedImage asphalt_kerb_yellow_upRight, asphalt_kerb_yellow_downRight,asphalt_kerb_yellow_upLeft,asphalt_kerb_yellow_downLeft;

    public static BufferedImage asphalt_kerb_red_up, asphalt_kerb_red_down,asphalt_kerb_red_Left,asphalt_kerb_red_Right;
    public static BufferedImage asphalt_kerb_yellow_up, asphalt_kerb_yellow_down,asphalt_kerb_yellow_Left,asphalt_kerb_yellow_Right;

    public static BufferedImage astroturf_kerb_red_upRight, astroturf_kerb_red_downRight,astroturf_kerb_red_upLeft,astroturf_kerb_red_downLeft;
    public static BufferedImage astroturf_kerb_yellow_upRight, astroturf_kerb_yellow_downRight,astroturf_kerb_yellow_upLeft,astroturf_kerb_yellow_downLeft;

    public static BufferedImage astroturfSMALL_kerb_red_upRight, astroturfSMALL_kerb_red_downRight,astroturfSMALL_kerb_red_upLeft,astroturfSMALL_kerb_red_downLeft;
    public static BufferedImage astroturfSMALL_kerb_yellow_upRight, astroturfSMALL_kerb_yellow_downRight,astroturfSMALL_kerb_yellow_upLeft,astroturfSMALL_kerb_yellow_downLeft;

    public static BufferedImage concrete,concrete60,concretePitLane,concretePitLaneExit,concretePitBox, concreteGrid;
    public static BufferedImage concrete_kerb_red_upRight, concrete_kerb_red_downRight,concrete_kerb_red_upLeft,concrete_kerb_red_downLeft;
    public static BufferedImage concrete_kerb_yellow_upRight, concrete_kerb_yellow_downRight,concrete_kerb_yellow_upLeft,concrete_kerb_yellow_downLeft;
    public static BufferedImage PirelliLogo1, PirelliLogo2, PirelliLogo3, RolexLogo1, RolexLogo2, ShellLogo,FlyEmirates1,FlyEmirates2;

    public static BufferedImage safetyCar1,safetyCar2,f1car1,f1car2,f1car3,f1car4,f1car5,f1car6,f1car7,pitCrew1,pitCrew2,crane1,crane2,crane3,crane4;

    public static BufferedImage[] StartButton,GuideButton,ExitButton,SettingsButton,ReturnButton,PirelliTyres,TemperateClimateButton,DesertClimateButton,car1Button,car2Button,car3Button,BackgroundImage;

    public static BufferedImage F1logo;

    public static int CarSelection=0;// variabila utilizata pentru alegerea masinii dorite de catre utilizator
    public static int ClimateSelection=0;// variabila utilizata pentru selectarea climei temperate sau a desertului

    public static void init(){
        SpriteSheet sheet=new SpriteSheet(ImageLoader.loadImage("/textures/sht.png"));

        player=sheet.crop(8*width,8*height,2*width,2*height);

        player_right = sheet.crop(0, 0, 2 * width, 2 * height);
        player_rightDOWN = sheet.crop(4 * width, 0, 2 * width, 2 * height);
        player_down = sheet.crop(8 * width, 0, 2 * width, 2 * height);
        player_leftDOWN = sheet.crop(12 * width, 0, 2 * width, 2 * height);
        player_left = sheet.crop(16 * width, 0, 2 * width, 2 * height);
        player_leftUP = sheet.crop(20 * width, 0, 2 * width, 2 * height);
        player_up = sheet.crop(24 * width, 0, 2 * width, 2 * height);
        player_rightUP = sheet.crop(28 * width, 0, 2 * width, 2 * height);

        grass= sheet.crop(0,6*height,width,height);
        grassFinishLine= sheet.crop(0,6*height,width,height);
        grassCutTheCorner=sheet.crop(0,6*height,width,height);

        gravel=sheet.crop(0,7*height,width,height);
        gravelCutTheCorner=sheet.crop(0,7*height,width,height);

        tyreBarrierWallUp=sheet.crop(2*width,7*height,width,height);
        tyreBarrierWallRight=sheet.crop(3*width,7*height,width,height);
        tyreBarrierWallDown=sheet.crop(4*width,7*height,width,height);
        tyreBarrierWallLeft=sheet.crop(5*width,7*height,width,height);

        asphalt=sheet.crop(width,6*height,width,height);
        Grid1=sheet.crop(6*width,7*height,width,height);
        Grid2=sheet.crop(7*width,7*height,width,height);
        finishLane=sheet.crop(8*width,7*height,width,height);
        astroturf=sheet.crop(9*width,7*height,width,height);
        astroturfFinishLine=sheet.crop(9*width,7*height,width,height);

        asphalt_kerb_red_up=sheet.crop(18*width,6*height,width,height);
        asphalt_kerb_yellow_up=sheet.crop(19*width,6*height,width,height);
        asphalt_kerb_red_Right=sheet.crop(20*width,6*height,width,height);
        asphalt_kerb_yellow_Right=sheet.crop(21*width,6*height,width,height);
        asphalt_kerb_red_down=sheet.crop(22*width,6*height,width,height);
        asphalt_kerb_yellow_down=sheet.crop(23*width,6*height,width,height);
        asphalt_kerb_red_Left=sheet.crop(24*width,6*height,width,height);
        asphalt_kerb_yellow_Left=sheet.crop(25*width,6*height,width,height);

        asphalt_kerb_red_upRight=sheet.crop(2*width,6*height,width,height);
        asphalt_kerb_yellow_upRight=sheet.crop(3*width,6*height,width,height);
        asphalt_kerb_red_downRight=sheet.crop(4*width,6*height,width,height);
        asphalt_kerb_yellow_downRight=sheet.crop(5*width,6*height,width,height);
        asphalt_kerb_red_downLeft=sheet.crop(6*width,6*height,width,height);
        asphalt_kerb_yellow_downLeft=sheet.crop(7*width,6*height,width,height);
        asphalt_kerb_red_upLeft=sheet.crop(8*width,6*height,width,height);
        asphalt_kerb_yellow_upLeft=sheet.crop(9*width,6*height,width,height);

        astroturf_kerb_red_upRight=sheet.crop(10*width,6*height,width,height);
        astroturf_kerb_yellow_upRight=sheet.crop(11*width,6*height,width,height);
        astroturf_kerb_red_downRight=sheet.crop(12*width,6*height,width,height);
        astroturf_kerb_yellow_downRight=sheet.crop(13*width,6*height,width,height);
        astroturf_kerb_red_downLeft=sheet.crop(14*width,6*height,width,height);
        astroturf_kerb_yellow_downLeft=sheet.crop(15*width,6*height,width,height);
        astroturf_kerb_red_upLeft=sheet.crop(16*width,6*height,width,height);
        astroturf_kerb_yellow_upLeft=sheet.crop(17*width,6*height,width,height);

        astroturfSMALL_kerb_red_upRight=sheet.crop(10*width,7*height,width,height);
        astroturfSMALL_kerb_yellow_upRight=sheet.crop(11*width,7*height,width,height);
        astroturfSMALL_kerb_red_downRight=sheet.crop(12*width,7*height,width,height);
        astroturfSMALL_kerb_yellow_downRight=sheet.crop(13*width,7*height,width,height);
        astroturfSMALL_kerb_red_downLeft=sheet.crop(14*width,7*height,width,height);
        astroturfSMALL_kerb_yellow_downLeft=sheet.crop(15*width,7*height,width,height);
        astroturfSMALL_kerb_red_upLeft=sheet.crop(16*width,7*height,width,height);
        astroturfSMALL_kerb_yellow_upLeft=sheet.crop(17*width,7*height,width,height);

        concrete=sheet.crop(25*width,8*height,width,height);
        concrete60=sheet.crop(24*width,8*height,width,height);
        concretePitLane=sheet.crop(23*width,8*height,width,height);
        concretePitLaneExit=sheet.crop(22*width,8*height,width,height);
        concretePitBox=sheet.crop(26*width,8*height,width,height);
        concreteGrid=sheet.crop(27*width,8*height,width,height);

        concrete_kerb_red_downRight=sheet.crop(18*width,7*height,width,height);
        concrete_kerb_yellow_downRight=sheet.crop(19*width,7*height,width,height);
        concrete_kerb_red_downLeft=sheet.crop(20*width,7*height,width,height);
        concrete_kerb_yellow_downLeft=sheet.crop(21*width,7*height,width,height);
        concrete_kerb_red_upLeft=sheet.crop(22*width,7*height,width,height);
        concrete_kerb_yellow_upLeft=sheet.crop(23*width,7*height,width,height);
        concrete_kerb_red_upRight=sheet.crop(24*width,7*height,width,height);
        concrete_kerb_yellow_upRight=sheet.crop(25*width,7*height,width,height);

        PirelliLogo1=sheet.crop(19*width,8*height,width,height);
        PirelliLogo2=sheet.crop(20*width,8*height,width,height);
        PirelliLogo3=sheet.crop(21*width,8*height,width,height);
        RolexLogo1=sheet.crop(16*width,8*height,width,height);
        RolexLogo2=sheet.crop(17*width,8*height,width,height);
        ShellLogo=sheet.crop(15*width,8*height,width,height);
        FlyEmirates1=sheet.crop(13*width,8*height,width,height);
        FlyEmirates2=sheet.crop(14*width,8*height,width,height);

        trophy=sheet.crop(10*width,8*height,2*width,2*height);

        safetyCar1=sheet.crop(26*width,7*height,width,height);
        safetyCar2=sheet.crop(27*width,7*height,width,height);

        f1car1=sheet.crop(21*width,9*height,width,height);
        f1car2=sheet.crop(22*width,9*height,width,height);
        f1car3=sheet.crop(23*width,9*height,width,height);
        f1car4=sheet.crop(24*width,9*height,width,height);
        f1car5=sheet.crop(25*width,9*height,width,height);
        f1car6=sheet.crop(26*width,9*height,width,height);
        f1car7=sheet.crop(27*width,9*height,width,height);

        pitCrew1=sheet.crop(19*width,9*height,width,height);
        pitCrew2=sheet.crop(20*width,9*height,width,height);

        crane1=sheet.crop(15*width,9*height,width,height);
        crane2=sheet.crop(16*width,9*height,width,height);
        crane3=sheet.crop(15*width,10*height,width,height);
        crane4=sheet.crop(16*width,10*height,width,height);

        StartButton=new BufferedImage[2];
        StartButton[0]=sheet.crop(21*width,12*height,2*width,height);
        StartButton[1]=sheet.crop(23*width,12*height,2*width,height);

        GuideButton=new BufferedImage[2];
        GuideButton[0]=sheet.crop(25*width,15*height,2*width,height);
        GuideButton[1]=sheet.crop(27*width,15*height,2*width,height);

        ExitButton=new BufferedImage[2];
        ExitButton[0]=sheet.crop(21*width,13*height,2*width,height);
        ExitButton[1]=sheet.crop(23*width,13*height,2*width,height);

        SettingsButton=new BufferedImage[2];
        SettingsButton[0]=sheet.crop(21*width,14*height,2*width,height);
        SettingsButton[1]=sheet.crop(23*width,14*height,2*width,height);

        ReturnButton=new BufferedImage[2];
        ReturnButton[0]=sheet.crop(21*width,15*height,2*width,height);
        ReturnButton[1]=sheet.crop(23*width,15*height,2*width,height);

        DesertClimateButton=new BufferedImage[2];
        DesertClimateButton[0]=sheet.crop(21*width,16*height,2*width,height);
        DesertClimateButton[1]=sheet.crop(23*width,16*height,2*width,height);

        TemperateClimateButton=new BufferedImage[2];
        TemperateClimateButton[0]=sheet.crop(21*width,17*height,2*width,height);
        TemperateClimateButton[1]=sheet.crop(23*width,17*height,2*width,height);

        car1Button=new BufferedImage[2];
        car1Button[0]=sheet.crop(25*width,12*height,2*width,height);
        car1Button[1]=sheet.crop(27*width,12*height,2*width,height);

        car2Button=new BufferedImage[2];
        car2Button[0]=sheet.crop(25*width,13*height,2*width,height);
        car2Button[1]=sheet.crop(27*width,13*height,2*width,height);

        car3Button=new BufferedImage[2];
        car3Button[0]=sheet.crop(25*width,14*height,2*width,height);
        car3Button[1]=sheet.crop(27*width,14*height,2*width,height);

        BackgroundImage=new BufferedImage[3];
        BackgroundImage[0]=sheet.crop(14*width,26*height,6*width,6*height);
        BackgroundImage[1]=sheet.crop(20*width,26*height,6*width,6*height);
        BackgroundImage[2]=sheet.crop(26*width,26*height,6*width,6*height);

        PirelliTyres=new BufferedImage[4];
        PirelliTyres[0]=sheet.crop(19*width,10*height,2*width,2*height);
        PirelliTyres[1]=sheet.crop(21*width,10*height,2*width,2*height);
        PirelliTyres[2]=sheet.crop(23*width,10*height,2*width,2*height);
        PirelliTyres[3]=sheet.crop(25*width,10*height,2*width,2*height);

        F1logo=sheet.crop(15*width,11*height,4*width,2*height);
    }

    public static void update(){
        SpriteSheet sheet=new SpriteSheet(ImageLoader.loadImage("/textures/sht.png"));

        if(CarSelection==2) {
            player_right = sheet.crop(0, 2 * height, 2 * width, 2 * height);
            player_rightDOWN = sheet.crop(4 * width, 2 * height, 2 * width, 2 * height);
            player_down = sheet.crop(8 * width, 2 * height, 2 * width, 2 * height);
            player_leftDOWN = sheet.crop(12 * width, 2 * height, 2 * width, 2 * height);
            player_left = sheet.crop(16 * width, 2 * height, 2 * width, 2 * height);
            player_leftUP = sheet.crop(20 * width, 2 * height, 2 * width, 2 * height);
            player_up = sheet.crop(24 * width, 2 * height, 2 * width, 2 * height);
            player_rightUP = sheet.crop(28 * width, 2 * height, 2 * width, 2 * height);
        }
        if(CarSelection==3) {
            player_right = sheet.crop(0, 4 * height, 2 * width, 2 * height);
            player_rightDOWN = sheet.crop(4 * width, 4 * height, 2 * width, 2 * height);
            player_down = sheet.crop(8 * width, 4 * height, 2 * width, 2 * height);
            player_leftDOWN = sheet.crop(12 * width, 4 * height, 2 * width, 2 * height);
            player_left = sheet.crop(16 * width, 4 * height, 2 * width, 2 * height);
            player_leftUP = sheet.crop(20 * width, 4 * height, 2 * width, 2 * height);
            player_up = sheet.crop(24 * width, 4 * height, 2 * width, 2 * height);
            player_rightUP = sheet.crop(28 * width, 4 * height, 2 * width, 2 * height);
        }

        if(ClimateSelection==2)
        {
            grass= sheet.crop(width,7*height,width,height);
            grassFinishLine= sheet.crop(width,7*height,width,height);
            grassCutTheCorner=sheet.crop(width,7*height,width,height);

            crane1=sheet.crop(13*width,9*height,width,height);
            crane2=sheet.crop(14*width,9*height,width,height);
            crane3=sheet.crop(13*width,10*height,width,height);
            crane4=sheet.crop(14*width,10*height,width,height);

            PirelliLogo1=sheet.crop(0,8*height,width,height);
            PirelliLogo2=sheet.crop(width,8*height,width,height);
            PirelliLogo3=sheet.crop(2*width,8*height,width,height);
            RolexLogo1=sheet.crop(17*width,10*height,width,height);
            RolexLogo2=sheet.crop(18*width,10*height,width,height);
            ShellLogo=sheet.crop(17*width,9*height,width,height);
        }
    }
}
