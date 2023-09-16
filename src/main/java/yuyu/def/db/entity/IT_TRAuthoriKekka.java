package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.mapping.GenIT_TRAuthoriKekka;


/**
 * オーソリ結果ＴＲテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_TRAuthoriKekka} の JavaDoc を参照してください。<br />
 * @see     GenIT_TRAuthoriKekka<br />
 * @see     PKIT_TRAuthoriKekka<br />
 * @see     QIT_TRAuthoriKekka<br />
 * @see     GenQIT_TRAuthoriKekka<br />
 */
@Entity
public class IT_TRAuthoriKekka extends GenIT_TRAuthoriKekka {

    private static final long serialVersionUID = 1L;

    public IT_TRAuthoriKekka() {
    }

    public IT_TRAuthoriKekka(String pSyono,BizDate pSyoriYmd,String pAuthorikktrrenno) {
        super(pSyono,pSyoriYmd,pAuthorikktrrenno);
    }



}

