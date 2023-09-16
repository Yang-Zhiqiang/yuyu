package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SmbcSkMeisaiRendouTy;
import yuyu.def.db.mapping.GenZT_SmbcSkMeisaiRendouTy;
import yuyu.def.db.meta.GenQZT_SmbcSkMeisaiRendouTy;
import yuyu.def.db.meta.QZT_SmbcSkMeisaiRendouTy;

/**
 * ＳＭＢＣ扱新契約明細連動テーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SmbcSkMeisaiRendouTy} の JavaDoc を参照してください。
 * @see     GenZT_SmbcSkMeisaiRendouTy
 * @see     PKZT_SmbcSkMeisaiRendouTy
 * @see     QZT_SmbcSkMeisaiRendouTy
 * @see     GenQZT_SmbcSkMeisaiRendouTy
 */
@Entity
public class ZT_SmbcSkMeisaiRendouTy extends GenZT_SmbcSkMeisaiRendouTy {

    private static final long serialVersionUID = 1L;

    public ZT_SmbcSkMeisaiRendouTy() {
    }

    public ZT_SmbcSkMeisaiRendouTy(
        String pZtysmbcdatakbn,
        String pZtysmbcdatasakuseiymd,
        String pZtysmbchknkaisyacd,
        String pZtysmbcuktkkanriid
    ) {
        super(
            pZtysmbcdatakbn,
            pZtysmbcdatasakuseiymd,
            pZtysmbchknkaisyacd,
            pZtysmbcuktkkanriid
        );
    }

}
