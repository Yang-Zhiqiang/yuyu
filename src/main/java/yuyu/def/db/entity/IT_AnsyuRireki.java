package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.db.mapping.GenIT_AnsyuRireki;


/**
 * 案内収納履歴テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_AnsyuRireki} の JavaDoc を参照してください。<br />
 * @see     GenIT_AnsyuRireki<br />
 * @see     PKIT_AnsyuRireki<br />
 * @see     QIT_AnsyuRireki<br />
 * @see     GenQIT_AnsyuRireki<br />
 */
@Entity
public class IT_AnsyuRireki extends GenIT_AnsyuRireki {

    private static final long serialVersionUID = 1L;

    public IT_AnsyuRireki() {
    }

    public IT_AnsyuRireki(String pKbnkey,String pSyono,C_NyknaiyouKbn pNyknaiyoukbn,BizDateYM pJyuutouym,Integer pAnnaino) {
        super(pKbnkey,pSyono,pNyknaiyoukbn,pJyuutouym,pAnnaino);
    }

    public IT_AnsyuRireki(String pSyono,C_NyknaiyouKbn pNyknaiyoukbn,BizDateYM pJyuutouym,Integer pAnnaino) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pNyknaiyoukbn,pJyuutouym,pAnnaino);
    }


    private IT_AnsyuKihon iT_AnsyuKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_AnsyuRireki.KBNKEY  , referencedColumnName=IT_AnsyuKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_AnsyuRireki.SYONO  , referencedColumnName=IT_AnsyuKihon.SYONO, insertable=false, updatable=false)
    })
    public IT_AnsyuKihon getAnsyuKihon() {
        return iT_AnsyuKihon;
    }

    public void setAnsyuKihon(IT_AnsyuKihon pIT_AnsyuKihon) {
        this.iT_AnsyuKihon = pIT_AnsyuKihon;
    }

}

