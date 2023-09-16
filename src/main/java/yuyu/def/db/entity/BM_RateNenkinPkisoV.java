package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenBM_RateNenkinPkisoV;


/**
 * 年金開始後Ｐ基礎Ｖレートマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_RateNenkinPkisoV} の JavaDoc を参照してください。<br />
 * @see     GenBM_RateNenkinPkisoV<br />
 * @see     PKBM_RateNenkinPkisoV<br />
 * @see     QBM_RateNenkinPkisoV<br />
 * @see     GenQBM_RateNenkinPkisoV<br />
 */
@Entity
public class BM_RateNenkinPkisoV extends GenBM_RateNenkinPkisoV {

    private static final long serialVersionUID = 1L;

    public BM_RateNenkinPkisoV() {
    }

    public BM_RateNenkinPkisoV(String pPalnenkinsisutemusyurui,String pPalnenkinsyuruikigou,String pPalnenkinkigousedaicode,String pPalnenkinsiharaikikan,String pPalnnknksgyoteiriritucode,String pPalnnknksgjmtesuuryoucode) {
        super(pPalnenkinsisutemusyurui,pPalnenkinsyuruikigou,pPalnenkinkigousedaicode,pPalnenkinsiharaikikan,pPalnnknksgyoteiriritucode,pPalnnknksgjmtesuuryoucode);
    }



}

