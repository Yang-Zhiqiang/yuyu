package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SmbcGetujiKykMeisaiRn;
import yuyu.def.db.mapping.GenZT_SmbcGetujiKykMeisaiRn;
import yuyu.def.db.meta.GenQZT_SmbcGetujiKykMeisaiRn;
import yuyu.def.db.meta.QZT_SmbcGetujiKykMeisaiRn;

/**
 * ＳＭＢＣ月次契約明細Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SmbcGetujiKykMeisaiRn} の JavaDoc を参照してください。
 * @see     GenZT_SmbcGetujiKykMeisaiRn
 * @see     PKZT_SmbcGetujiKykMeisaiRn
 * @see     QZT_SmbcGetujiKykMeisaiRn
 * @see     GenQZT_SmbcGetujiKykMeisaiRn
 */
@Entity
public class ZT_SmbcGetujiKykMeisaiRn extends GenZT_SmbcGetujiKykMeisaiRn {

    private static final long serialVersionUID = 1L;

    public ZT_SmbcGetujiKykMeisaiRn() {
    }

    public ZT_SmbcGetujiKykMeisaiRn(
        String pZrndatakijyunymd,
        String pZrndatakijyunym,
        String pZrnsyono
    ) {
        super(
            pZrndatakijyunymd,
            pZrndatakijyunym,
            pZrnsyono
        );
    }

}
