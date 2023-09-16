package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.db.mapping.GenHM_SkHokenSyuruiNo;

/**
 * 保険種類番号マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHM_SkHokenSyuruiNo} の JavaDoc を参照してください。<br />
 * @see     GenHM_SkHokenSyuruiNo<br />
 * @see     PKHM_SkHokenSyuruiNo<br />
 * @see     QHM_SkHokenSyuruiNo<br />
 * @see     GenQHM_SkHokenSyuruiNo<br />
 */
@Entity
public class HM_SkHokenSyuruiNo extends GenHM_SkHokenSyuruiNo {

    private static final long serialVersionUID = 1L;

    public HM_SkHokenSyuruiNo() {
    }

    public HM_SkHokenSyuruiNo(C_HknsyuruiNo pHknsyuruino,Integer pHknsyuruinosd) {
        super(pHknsyuruino,pHknsyuruinosd);
    }



}

