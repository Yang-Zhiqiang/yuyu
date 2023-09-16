package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SmbcSkMeisaiRendouRn;
import yuyu.def.db.mapping.GenZT_SmbcSkMeisaiRendouRn;
import yuyu.def.db.meta.GenQZT_SmbcSkMeisaiRendouRn;
import yuyu.def.db.meta.QZT_SmbcSkMeisaiRendouRn;

/**
 * ＳＭＢＣ扱新契約明細連動テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SmbcSkMeisaiRendouRn} の JavaDoc を参照してください。
 * @see     GenZT_SmbcSkMeisaiRendouRn
 * @see     PKZT_SmbcSkMeisaiRendouRn
 * @see     QZT_SmbcSkMeisaiRendouRn
 * @see     GenQZT_SmbcSkMeisaiRendouRn
 */
@Entity
public class ZT_SmbcSkMeisaiRendouRn extends GenZT_SmbcSkMeisaiRendouRn {

    private static final long serialVersionUID = 1L;

    public ZT_SmbcSkMeisaiRendouRn() {
    }

    public ZT_SmbcSkMeisaiRendouRn(
        String pZrnsmbcdatakbn,
        String pZrnsmbcdatasakuseiymd,
        String pZrnsmbchknkaisyacd,
        String pZrnsmbcuktkkanriid
    ) {
        super(
            pZrnsmbcdatakbn,
            pZrnsmbcdatasakuseiymd,
            pZrnsmbchknkaisyacd,
            pZrnsmbcuktkkanriid
        );
    }

}
