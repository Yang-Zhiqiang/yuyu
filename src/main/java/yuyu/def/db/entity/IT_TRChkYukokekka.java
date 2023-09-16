package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.mapping.GenIT_TRChkYukokekka;


/**
 * 有効性確認結果ＴＲテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_TRChkYukokekka} の JavaDoc を参照してください。<br />
 * @see     GenIT_TRChkYukokekka<br />
 * @see     PKIT_TRChkYukokekka<br />
 * @see     QIT_TRChkYukokekka<br />
 * @see     GenQIT_TRChkYukokekka<br />
 */
@Entity
public class IT_TRChkYukokekka extends GenIT_TRChkYukokekka {

    private static final long serialVersionUID = 1L;

    public IT_TRChkYukokekka() {
    }

    public IT_TRChkYukokekka(String pSyono,BizDate pSyoriYmd,String pYuukoutrrenno) {
        super(pSyono,pSyoriYmd,pYuukoutrrenno);
    }



}

