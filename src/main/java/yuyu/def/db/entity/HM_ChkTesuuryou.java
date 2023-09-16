package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenHM_ChkTesuuryou;


/**
 * 手数料チェックマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHM_ChkTesuuryou} の JavaDoc を参照してください。<br />
 * @see     GenHM_ChkTesuuryou<br />
 * @see     PKHM_ChkTesuuryou<br />
 * @see     QHM_ChkTesuuryou<br />
 * @see     GenQHM_ChkTesuuryou<br />
 */
@Entity
public class HM_ChkTesuuryou extends GenHM_ChkTesuuryou {

    private static final long serialVersionUID = 1L;

    public HM_ChkTesuuryou() {
    }

    public HM_ChkTesuuryou(Integer pRenno3keta) {
        super(pRenno3keta);
    }



}

