package src;
/**
 * @author R. Springer
 */
public class TileFactory {

    /**
     * Creates a Tile object based on the mapIcon number you give
     *
     * @param mapIcon number
     * @return Tile tile object
     */
    protected Tile createTile(int mapIcon) {
        Tile tile = new Tile();
        tile.isSolid = true;
        switch (mapIcon) {
            case 0:
                tile.setTileImage("box");
                tile.setType(TileType.BOX);
                break;
            case 1:
                tile.setTileImage("boxAlt");
                tile.setType(TileType.BOX);
                break;
            case 2:
                tile.setTileImage("boxCoin");
                tile.setType(TileType.COINBOX);
                break;
            case 3:
                tile.setTileImage("boxCoinAlt");
                break;
            case 4:
                tile.setTileImage("boxCoinAltDisabled");
                tile.setType(TileType.BOX);
                break;
            case 5:
                tile.setTileImage("boxCoinDisabled");
                tile.setType(TileType.BOX);
                break;
            case 6:
                tile.setTileImage("boxEmpty");
                tile.setType(TileType.BREAKABLEBLOCK);
                break;
            case 7:
                tile.setTileImage("boxExplosive");
                tile.setType(TileType.BOX);
                break;
            case 8:
                tile.setTileImage("boxExplosiveAlt");
                tile.setType(TileType.BOX);
                break;
            case 9:
                tile.setTileImage("boxExplosiveDisabled");
                tile.setType(TileType.BOX);
                break;
            case 10:
                tile.setTileImage("boxItem");
                tile.setType(TileType.BOX);
                break;
            case 11:
                tile.setTileImage("boxItemAlt");
                tile.setType(TileType.BOX);
                break;
            case 12:
                tile.setTileImage("boxItemAltDisabled");
                tile.setType(TileType.BOX);
                break;
            case 13:
                tile.setTileImage("boxItemDisabled");
                tile.setType(TileType.BOX);
                break;
            case 14:
                tile.setTileImage("boxWarning");
                tile.setType(TileType.BOX);
                break;
            case 15:
                tile.setTileImage("brickWall");
                break;
            case 16:
                tile.setTileImage("bridge");
                tile.getImage().mirrorVertically();
                tile.setType(TileType.BRIDGE);
                break;
            case 17:
                tile.setTileImage("bridgeLogs");
                tile.getImage().mirrorVertically();
                tile.setType(TileType.BRIDGE);
                break;
            case 18:
                tile.setTileImage("castle");
                break;
            case 19:
                tile.setTileImage("castleCenter");
                break;
            case 20:
                tile.setTileImage("castleCenterRounded");
                break;
            case 21:
                tile.setTileImage("castleCliffLeft");
                break;
            case 22:
                tile.setTileImage("castleCliffLeftAlt");
                break;
            case 23:
                tile.setTileImage("castleCliffRight");
                break;
            case 24:
                tile.setTileImage("castleCliffRightAlt");
                break;
            case 25:
                tile.setTileImage("castleHalf");
                break;
            case 26:
                tile.setTileImage("castleHalfLeft");
                break;
            case 27:
                tile.setTileImage("castleHalfMid");
                break;
            case 28:
                tile.setTileImage("castleHalfRight");
                break;
            case 29:
                tile.setTileImage("castleHillLeft");
                tile.isSolid = false;
                break;
            case 30:
                tile.setTileImage("castleHillLeft2");
                tile.isSolid = false;
                break;
            case 31:
                tile.setTileImage("castleHillRight");
                tile.isSolid = false;
                break;
            case 32:
                tile.setTileImage("castleHillRight2");
                tile.isSolid = false;
                break;
            case 33:
                tile.setTileImage("castleLedgeLeft");
                break;
            case 34:
                tile.setTileImage("castleLedgeRight");
                break;
            case 35:
                tile.setTileImage("castleLeft");
                break;
            case 36:
                tile.setTileImage("castleMid");
                break;
            case 37:
                tile.setTileImage("castleRight");
                break;
            case 38:
                tile.setTileImage("dirt");
                break;
            case 39:
                tile.setTileImage("dirtCenter");
                break;
            case 40:
                tile.setTileImage("dirtCenterRounded");
                break;
            case 41:
                tile.setTileImage("dirtCliffLeft");
                break;
            case 42:
                tile.setTileImage("dirtCliffLeftAlt");
                break;
            case 43:
                tile.setTileImage("dirtCliffRight");
                break;
            case 44:
                tile.setTileImage("dirtCliffRightAlt");
                break;
            case 45:
                tile.setTileImage("dirtHalf");
                break;
            case 46:
                tile.setTileImage("dirtHalfLeft");
                break;
            case 47:
                tile.setTileImage("dirtHalfMid");
                break;
            case 48:
                tile.setTileImage("dirtHalfRight");
                break;
            case 49:
                tile.setTileImage("dirtHillLeft");
                break;
            case 50:
                tile.setTileImage("dirtHillLeft2");
                break;
            case 51:
                tile.setTileImage("dirtHillRight");
                break;
            case 52:
                tile.setTileImage("dirtHillRight2");
                break;
            case 53:
                tile.setTileImage("dirtLedgeLeft");
                break;
            case 54:
                tile.setTileImage("dirtLedgeRight");
                break;
            case 55:
                tile.setTileImage("dirtLeft");
                break;
            case 56:
                tile.setTileImage("dirtMid");
                break;
            case 57:
                tile.setTileImage("dirtRight");
                break;
            case 58:
                tile.setTileImage("doorClosedMid");
                tile.isSolid = false;
                break;
            case 59:
                tile.setTileImage("doorClosedTop");
                tile.isSolid = false;
                break;
            case 60:
                tile.setTileImage("doorOpenMid");
                tile.isSolid = false;
                break;
            case 61:
                tile.setTileImage("doorOpenTop");
                tile.isSolid = false;
                break;
            case 62:
                tile.setTileImage("fence");
                tile.isSolid = false;
                break;
            case 63:
                tile.setTileImage("fenceBroken");
                tile.isSolid = false;
                break;
            case 64:
                tile.setTileImage("grass");
                break;
            case 65:
                tile.setTileImage("grassCenter");
                break;
            case 66:
                tile.setTileImage("grassCenterRounded");
                break;
            case 67:
                tile.setTileImage("grassCliffLeft");
                break;
            case 68:
                tile.setTileImage("grassCliffLeftAlt");
                break;
            case 69:
                tile.setTileImage("grassCliffRight");
                break;
            case 70:
                tile.setTileImage("grassCliffRightAlt");
                break;
            case 71:
                tile.setTileImage("grassHalf");
                break;
            case 72:
                tile.setTileImage("grassHalfLeft");
                break;
            case 73:
                tile.setTileImage("grassHalfMid");
                break;
            case 74:
                tile.setTileImage("grassHalfRight");
                break;
            case 75:
                tile.setTileImage("grassHillLeft");
                break;
            case 76:
                tile.setTileImage("grassHillLeft2");
                break;
            case 77:
                tile.setTileImage("grassHillRight");
                break;
            case 78:
                tile.setTileImage("grassHillRight2");
                break;
            case 79:
                tile.setTileImage("grassLedgeLeft");
                break;
            case 80:
                tile.setTileImage("grassLedgeRight");
                break;
            case 81:
                tile.setTileImage("grassLeft");
                break;
            case 82:
                tile.setTileImage("grassMid");
                break;
            case 83:
                tile.setTileImage("grassRight");
                break;
            case 84:
                tile.setTileImage("hillLarge");
                tile.getImage().scale(48, 146);
                tile.isSolid = false;
                break;
            case 85:
                tile.setTileImage("hillLargeAlt");
                tile.getImage().scale(48, 146);
                tile.isSolid = false;
                break;
            case 86:
                tile.setTileImage("hillSmall");
                tile.getImage().scale(48, 106);
                tile.isSolid = false;
                break;
            case 87:
                tile.setTileImage("hillSmallAlt");
                tile.getImage().scale(48, 106);
                tile.isSolid = false;
                break;
            case 88:
                tile.setTileImage("ladderMid");
                tile.setType(TileType.LADDER);
                tile.isSolid = false;
                break;
            case 89:
                tile.setTileImage("ladderTop");
                tile.setType(TileType.LADDER);
                tile.isSolid = false;
                break;
            case 90:
                tile.setTileImage("liquidLava");
                tile.setType(TileType.LIQUID);
                tile.isSolid = false;
                break;
            case 91:
                tile.setTileImage("liquidLavaTop");
                tile.setType(TileType.LIQUID);
                tile.isSolid = false;
                break;
            case 92:
                tile.setTileImage("liquidLavaTopMid");
                tile.setType(TileType.LIQUID);
                tile.isSolid = false;
                break;
            case 93:
                tile.setTileImage("liquidWater");
                tile.setType(TileType.LIQUID);
                tile.isSolid = false;
                break;
            case 94:
                tile.setTileImage("liquidWaterTop");
                tile.setType(TileType.LIQUID);
                tile.isSolid = false;
                break;
            case 95:
                tile.setTileImage("liquidWaterTopMid");
                tile.setType(TileType.LIQUID);
                tile.isSolid = false;
                break;
            case 96:
                tile.setTileImage("lockBlue");
                break;
            case 97:
                tile.setTileImage("lockGreen");
                break;
            case 98:
                tile.setTileImage("lockRed");
                break;
            case 99:
                tile.setTileImage("lockYellow");
                break;
            case 100:
                tile.setTileImage("rockHillLeft");
                break;
            case 101:
                tile.setTileImage("rockHillRight");
                break;
            case 102:
                tile.setTileImage("ropeAttached");
                tile.isSolid = false;
                break;
            case 103:
                tile.setTileImage("ropeHorizontal");
                tile.isSolid = false;
                break;
            case 104:
                tile.setTileImage("ropeVertical");
                tile.isSolid = false;
                break;
            case 105:
                tile.setTileImage("sand");
                break;
            case 106:
                tile.setTileImage("sandCenter");
                break;
            case 107:
                tile.setTileImage("sandCenterRounded");
                break;
            case 108:
                tile.setTileImage("sandCliffLeft");
                break;
            case 109:
                tile.setTileImage("sandCliffLeftAlt");
                break;
            case 110:
                tile.setTileImage("sandCliffRight");
                break;
            case 111:
                tile.setTileImage("sandCliffRightAlt");
                break;
            case 112:
                tile.setTileImage("sandHalf");
                break;
            case 113:
                tile.setTileImage("sandHalfLeft");
                break;
            case 114:
                tile.setTileImage("sandHalfMid");
                break;
            case 115:
                tile.setTileImage("sandHalfRight");
                break;
            case 116:
                tile.setTileImage("sandHillLeft");
                break;
            case 117:
                tile.setTileImage("sandHillLeft2");
                break;
            case 118:
                tile.setTileImage("sandHillRight");
                break;
            case 119:
                tile.setTileImage("sandHillRight2");
                break;
            case 120:
                tile.setTileImage("sandLedgeLeft");
                break;
            case 121:
                tile.setTileImage("sandLedgeRight");
                break;
            case 122:
                tile.setTileImage("sandLeft");
                break;
            case 123:
                tile.setTileImage("sandMid");
                break;
            case 124:
                tile.setTileImage("sandRight");
                break;
            case 125:
                tile.setTileImage("sign");
                tile.isSolid = false;
                break;
            case 126:
                tile.setTileImage("signExit");
                tile.isSolid = false;
                break;
            case 127:
                tile.setTileImage("signLeft");
                tile.isSolid = false;
                break;
            case 128:
                tile.setTileImage("signRight");
                tile.isSolid = false;
                break;
            case 129:
                tile.setTileImage("snow");
                break;
            case 130:
                tile.setTileImage("snowCenter");
                break;
            case 131:
                tile.setTileImage("snowCenterRounded");
                break;
            case 132:
                tile.setTileImage("snowCliffLeft");
                break;
            case 133:
                tile.setTileImage("snowCliffLeftAlt");
                break;
            case 134:
                tile.setTileImage("snowCliffRight");
                break;
            case 135:
                tile.setTileImage("snowCliffRightAlt");
                break;
            case 136:
                tile.setTileImage("snowHalf");
                break;
            case 137:
                tile.setTileImage("snowHalfLeft");
                break;
            case 138:
                tile.setTileImage("snowHalfMid");
                break;
            case 139:
                tile.setTileImage("snowHalfRight");
                break;
            case 140:
                tile.setTileImage("snowHillLeft");
                break;
            case 141:
                tile.setTileImage("snowHillLeft2");
                break;
            case 142:
                tile.setTileImage("snowHillRight");
                break;
            case 143:
                tile.setTileImage("snowHillRight2");
                break;
            case 144:
                tile.setTileImage("snowLedgeLeft");
                break;
            case 145:
                tile.setTileImage("snowLedgeRight");
                break;
            case 146:
                tile.setTileImage("snowLeft");
                break;
            case 147:
                tile.setTileImage("snowMid");
                break;
            case 148:
                tile.setTileImage("snowRight");
                break;
            case 149:
                tile.setTileImage("stone");
                break;
            case 150:
                tile.setTileImage("stoneCenter");
                break;
            case 151:
                tile.setTileImage("stoneCenterRounded");
                break;
            case 152:
                tile.setTileImage("stoneCliffLeft");
                break;
            case 153:
                tile.setTileImage("stoneCliffLeftAlt");
                break;
            case 154:
                tile.setTileImage("stoneCliffRight");
                break;
            case 155:
                tile.setTileImage("stoneCliffRightAlt");
                break;
            case 156:
                tile.setTileImage("stoneHalf");
                break;
            case 157:
                tile.setTileImage("stoneHalfLeft");
                break;
            case 158:
                tile.setTileImage("stoneHalfMid");
                break;
            case 159:
                tile.setTileImage("stoneHalfRight");
                break;
            case 160:
                tile.setTileImage("stoneHillLeft2");
                break;
            case 161:
                tile.setTileImage("stoneHillRight2");
                break;
            case 162:
                tile.setTileImage("stoneLedgeLeft");
                break;
            case 163:
                tile.setTileImage("stoneLedgeRight");
                break;
            case 164:
                tile.setTileImage("stoneLeft");
                break;
            case 165:
                tile.setTileImage("stoneMid");
                break;
            case 166:
                tile.setTileImage("stoneRight");
                break;
            case 167:
                tile.setTileImage("stoneWall");
                break;
            case 168:
                tile.setTileImage("tochLit");
                tile.isSolid = false;
                break;
            case 169:
                tile.setTileImage("tochLit2");
                tile.isSolid = false;
                break;
            case 170:
                tile.setTileImage("torch");
                tile.isSolid = false;
                break;
            case 171:
                tile.setTileImage("window");
                tile.isSolid = false;
                break;
            default:
                tile.setTileImage("grassMid");
                break;
        }
        return tile;
    }
}
