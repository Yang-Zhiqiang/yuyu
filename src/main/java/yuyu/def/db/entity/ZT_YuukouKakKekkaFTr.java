package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_YuukouKakKekkaFTr;
import yuyu.def.db.mapping.GenZT_YuukouKakKekkaFTr;
import yuyu.def.db.meta.GenQZT_YuukouKakKekkaFTr;
import yuyu.def.db.meta.QZT_YuukouKakKekkaFTr;

/**
 * 有効性確認結果Ｆテーブル（取） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_YuukouKakKekkaFTr} の JavaDoc を参照してください。
 * @see     GenZT_YuukouKakKekkaFTr
 * @see     PKZT_YuukouKakKekkaFTr
 * @see     QZT_YuukouKakKekkaFTr
 * @see     GenQZT_YuukouKakKekkaFTr
 */
@Entity
public class ZT_YuukouKakKekkaFTr extends GenZT_YuukouKakKekkaFTr {

    private static final long serialVersionUID = 1L;

    public ZT_YuukouKakKekkaFTr() {
    }

    public ZT_YuukouKakKekkaFTr(String pZtrcreditkessaiyouno) {
        super(pZtrcreditkessaiyouno);
    }

}
