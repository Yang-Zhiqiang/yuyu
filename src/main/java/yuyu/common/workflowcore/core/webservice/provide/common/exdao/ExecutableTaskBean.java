package yuyu.common.workflowcore.core.webservice.provide.common.exdao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 実行可能タスク取得Bean
 */
@AllArgsConstructor
@ToString
public class ExecutableTaskBean {

    @Getter @Setter
    private String actorId_;
    @Getter @Setter
    private Long procInst_;
    @Getter @Setter
    private String name_;
    @Getter @Setter
    private Long version_;

}
