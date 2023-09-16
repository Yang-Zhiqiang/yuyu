package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_YuukouKakKekkaFRn;
import yuyu.def.db.mapping.GenZT_YuukouKakKekkaFRn;
import yuyu.def.db.meta.GenQZT_YuukouKakKekkaFRn;
import yuyu.def.db.meta.QZT_YuukouKakKekkaFRn;

/**
 * 有効性確認結果Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_YuukouKakKekkaFRn} の JavaDoc を参照してください。
 * @see     GenZT_YuukouKakKekkaFRn
 * @see     PKZT_YuukouKakKekkaFRn
 * @see     QZT_YuukouKakKekkaFRn
 * @see     GenQZT_YuukouKakKekkaFRn
 */
@Entity
public class ZT_YuukouKakKekkaFRn extends GenZT_YuukouKakKekkaFRn {

    private static final long serialVersionUID = 1L;

    public ZT_YuukouKakKekkaFRn() {
    }

    public ZT_YuukouKakKekkaFRn(String pZrncreditkessaiyouno) {
        super(pZrncreditkessaiyouno);
    }

}
