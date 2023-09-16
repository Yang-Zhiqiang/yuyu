package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKIT_BunrimaeAuthoriKekka;
import yuyu.def.db.mapping.GenIT_BunrimaeAuthoriKekka;
import yuyu.def.db.meta.GenQIT_BunrimaeAuthoriKekka;
import yuyu.def.db.meta.QIT_BunrimaeAuthoriKekka;

/**
 * 分離前オーソリ結果テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_BunrimaeAuthoriKekka} の JavaDoc を参照してください。
 * @see     GenIT_BunrimaeAuthoriKekka
 * @see     PKIT_BunrimaeAuthoriKekka
 * @see     QIT_BunrimaeAuthoriKekka
 * @see     GenQIT_BunrimaeAuthoriKekka
 */
@Entity
public class IT_BunrimaeAuthoriKekka extends GenIT_BunrimaeAuthoriKekka {

    private static final long serialVersionUID = 1L;

    public IT_BunrimaeAuthoriKekka() {
    }

    public IT_BunrimaeAuthoriKekka(String pCreditkessaiyouno, String pDatajyusinymd) {
        super(pCreditkessaiyouno, pDatajyusinymd);
    }

}
