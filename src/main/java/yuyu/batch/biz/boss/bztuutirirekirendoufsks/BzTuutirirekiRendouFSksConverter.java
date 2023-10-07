package yuyu.batch.biz.boss.bztuutirirekirendoufsks;

import yuyu.def.db.entity.ZT_TuutirirekiMeisaiFTy;

import com.google.common.base.Strings;

/**
 * 業務共通 ＢＯＳＳ 普保Ⅱ通知履歴連動Ｆ作成コンバーター
 */
public class BzTuutirirekiRendouFSksConverter {

    public static void convertPadding(ZT_TuutirirekiMeisaiFTy pTuutirirekiMeisaiFTy) {

        pTuutirirekiMeisaiFTy.setZtytuutirirekino(Strings.padStart(pTuutirirekiMeisaiFTy.getZtytuutirirekino(), 13, '0'));
        pTuutirirekiMeisaiFTy.setZtytuutisakuseiymd(Strings.padStart(pTuutirirekiMeisaiFTy.getZtytuutisakuseiymd(), 8, '0'));
        pTuutirirekiMeisaiFTy.setZtytuutisakuseino(Strings.padStart(pTuutirirekiMeisaiFTy.getZtytuutisakuseino(), 2, '0'));
        pTuutirirekiMeisaiFTy.setZtyhyoujiyoutuutisksymd(Strings.padStart(pTuutirirekiMeisaiFTy.getZtyhyoujiyoutuutisksymd(), 8, '0'));


    }
}
