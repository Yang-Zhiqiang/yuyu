package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKJT_AksrendouzumiSyoruiImg;
import yuyu.def.db.mapping.GenJT_AksrendouzumiSyoruiImg;
import yuyu.def.db.meta.GenQJT_AksrendouzumiSyoruiImg;
import yuyu.def.db.meta.QJT_AksrendouzumiSyoruiImg;

/**
 * ＡＫＳ連動済書類情報テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJT_AksrendouzumiSyoruiImg} の JavaDoc を参照してください。
 * @see     GenJT_AksrendouzumiSyoruiImg
 * @see     PKJT_AksrendouzumiSyoruiImg
 * @see     QJT_AksrendouzumiSyoruiImg
 * @see     GenQJT_AksrendouzumiSyoruiImg
 */
@Entity
public class JT_AksrendouzumiSyoruiImg extends GenJT_AksrendouzumiSyoruiImg {

    private static final long serialVersionUID = 1L;

    public JT_AksrendouzumiSyoruiImg() {
    }

    public JT_AksrendouzumiSyoruiImg(
        String pSkno,
        String pSyono,
        String pImageid
    ) {
        super(
            pSkno,
            pSyono,
            pImageid
        );
    }

}
