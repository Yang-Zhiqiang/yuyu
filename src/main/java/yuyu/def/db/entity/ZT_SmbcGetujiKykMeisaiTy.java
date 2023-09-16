package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SmbcGetujiKykMeisaiTy;
import yuyu.def.db.mapping.GenZT_SmbcGetujiKykMeisaiTy;
import yuyu.def.db.meta.GenQZT_SmbcGetujiKykMeisaiTy;
import yuyu.def.db.meta.QZT_SmbcGetujiKykMeisaiTy;

/**
 * ＳＭＢＣ月次契約明細Ｆテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SmbcGetujiKykMeisaiTy} の JavaDoc を参照してください。
 * @see     GenZT_SmbcGetujiKykMeisaiTy
 * @see     PKZT_SmbcGetujiKykMeisaiTy
 * @see     QZT_SmbcGetujiKykMeisaiTy
 * @see     GenQZT_SmbcGetujiKykMeisaiTy
 */
@Entity
public class ZT_SmbcGetujiKykMeisaiTy extends GenZT_SmbcGetujiKykMeisaiTy {

    private static final long serialVersionUID = 1L;

    public ZT_SmbcGetujiKykMeisaiTy() {
    }

    public ZT_SmbcGetujiKykMeisaiTy(
        String pZtydatakijyunymd,
        String pZtydatakijyunym,
        String pZtysyono
    ) {
        super(
            pZtydatakijyunymd,
            pZtydatakijyunym,
            pZtysyono
        );
    }

}
