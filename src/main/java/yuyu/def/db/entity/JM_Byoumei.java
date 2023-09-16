package yuyu.def.db.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import yuyu.def.db.mapping.GenJM_Byoumei;

import com.google.common.collect.Lists;


/**
 * 病名マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJM_Byoumei} の JavaDoc を参照してください。<br />
 * @see     GenJM_Byoumei<br />
 * @see     PKJM_Byoumei<br />
 * @see     QJM_Byoumei<br />
 * @see     GenQJM_Byoumei<br />
 */
@Entity
public class JM_Byoumei extends GenJM_Byoumei {

    private static final long serialVersionUID = 1L;

    public JM_Byoumei() {
    }

    public JM_Byoumei(String pByoumeitourokuno) {
        super(pByoumeitourokuno);
    }



    private List<JM_TokusyuKyuHantei> jM_TokusyuKyuHanteis = Lists.newLinkedList();
    public JM_TokusyuKyuHantei createTokusyuKyuHantei() {
        JM_TokusyuKyuHantei tokusyuKyuHantei =  new JM_TokusyuKyuHantei();
        tokusyuKyuHantei.setByoumei(this);
        tokusyuKyuHantei.setByoumeitourokuno(this.getByoumeitourokuno());
        getTokusyuKyuHanteis().add(tokusyuKyuHantei);
        return tokusyuKyuHantei;
    }
    public void setTokusyuKyuHanteis(List<JM_TokusyuKyuHantei> pJM_TokusyuKyuHanteis) {
        this.jM_TokusyuKyuHanteis = pJM_TokusyuKyuHanteis;
    }
    @OneToMany (
        mappedBy = "byoumei",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
        @OrderBy(JM_TokusyuKyuHantei.BYOUMEITOUROKUNO+" ASC ,"+JM_TokusyuKyuHantei.SYOUHNCD+" ASC ,"+JM_TokusyuKyuHantei.SYOUHNSDNO+" ASC ,"+JM_TokusyuKyuHantei.TEKIYOUKKNFROM+" ASC ,"+JM_TokusyuKyuHantei.TEKIYOUKKNKTO+" ASC ")
    public  List<JM_TokusyuKyuHantei> getTokusyuKyuHanteis() {
        return jM_TokusyuKyuHanteis;
    }

}

