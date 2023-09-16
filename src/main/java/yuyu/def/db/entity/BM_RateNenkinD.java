package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenBM_RateNenkinD;


/**
 * 年金開始後Ｄレートマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_RateNenkinD} の JavaDoc を参照してください。<br />
 * @see     GenBM_RateNenkinD<br />
 * @see     PKBM_RateNenkinD<br />
 * @see     QBM_RateNenkinD<br />
 * @see     GenQBM_RateNenkinD<br />
 */
@Entity
public class BM_RateNenkinD extends GenBM_RateNenkinD {

    private static final long serialVersionUID = 1L;

    public BM_RateNenkinD() {
    }

    public BM_RateNenkinD(String pPalnenkinsisutemusyurui,String pPalnenkinsyuruikigou,String pPalnenkinkigousedaicode,String pPalnenkinsiharaikikan,String pPalnnknksgyoteiriritucode,String pPalnnknksgjmtesuuryoucode,String pPaldnendo,String pPaldratenaikakucode) {
        super(pPalnenkinsisutemusyurui,pPalnenkinsyuruikigou,pPalnenkinkigousedaicode,pPalnenkinsiharaikikan,pPalnnknksgyoteiriritucode,pPalnnknksgjmtesuuryoucode,pPaldnendo,pPaldratenaikakucode);
    }



}

