package yuyu.common.workflowcore.core.webservice.provide.common.exdao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * タスクサマリ作成Bean
 */
@AllArgsConstructor
@ToString
public class CreateTaskSummaryBean {

    @Getter @Setter
    private String taskName_;
    @Getter @Setter
    private String taskDescription_;
    @Getter @Setter
    private String create_;
    @Getter @Setter
    private String start_;
    @Getter @Setter
    private String end_;
    @Getter @Setter
    private Long token_;
    @Getter @Setter
    private String actorId_;
    @Getter @Setter
    private String processName_;
    @Getter @Setter
    private String processDescription_;
}
