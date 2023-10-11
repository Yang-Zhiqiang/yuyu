package createdata;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class CreateData {

    static void init() {

        Map<String, String> temp;

        for (int i = 0; i < 10; i++) {

            temp = new HashMap<String, String>();

            temp.put(CreateDataConstants.KEY_PROCESSDEFINITION, CreateDataConstants.PROCESSDEFINITIONARRAY[i]);
            temp.put(CreateDataConstants.KEY_NODE, CreateDataConstants.NODEARRAY[i]);
            temp.put(CreateDataConstants.KEY_TASKMGMTDEFINITION, CreateDataConstants.TASKMGMTDEFINITIONARRAY[i]);
            temp.put(CreateDataConstants.KEY_NAME, CreateDataConstants.NAMEARRAY[i]);
            temp.put(CreateDataConstants.KEY_TASK, CreateDataConstants.TASKARRAY[i]);
            temp.put(CreateDataConstants.KEY_FLOWID, CreateDataConstants.FLOWIDARRAY[i]);
            temp.put(CreateDataConstants.KEY_RIREKINODEID, CreateDataConstants.RIREKINODEIDARRAY[i]);
            temp.put(CreateDataConstants.KEY_ENDNODE, CreateDataConstants.ENDNODEARRAY[i]);

            CreateDataConstants.mapList.add(temp);
        }

    }

    public static void main(String[] args) {
        try {
            init();
            createInsertJBPMPROCESSINSTANCESql();
            createUpdateJBPMPROCESSINSTANCESql();

            createInsertJBPMTOKENSql();
            createUpdateJBPMTOKENSql();

            createInsertJBPMMODULEINSTANCESql();

            createInsertJBPMTOKENVARIABLEMAPSql();

            createInsertJBPMTASKINSTANCESql();

            createInsertJBPMVARIABLEINSTANCESql();

            createInsertITImageArriveNoticesql();

            createInsertITGyoumuKeysql();

            createInsertITPDFHozonsql();

            createInsertITPagesql();

            createInsertITTorikomiKanrisql();

            createInsertITTorikomiRelationsql();

            createInsertITKouteiSummarySql();

            createInsertITKouteiRirekiSql();

        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        System.out.println("all create complete.");

    }

    private static void createInsertJBPMPROCESSINSTANCESql() throws IOException {
        long cnt = 0;
        File file = new File(CreateDataConstants.filepath + CreateDataConstants.dirpath1
            + CreateDataConstants.filename_JBPM_PROCESSINSTANCE_INSERT);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));

        Map<String, String> temp = null;

        int cnt1 = 0;
        for (cnt = 0; cnt < CreateDataConstants.cnt_max; cnt++) {
            if (cnt % (CreateDataConstants.cnt_max / 10) == 0) {
                temp = CreateDataConstants.mapList.get(cnt1);
                //                if(cnt1 == CreateDataConstants.mapList.size() - 1){
                //                    cnt1 = 0;
                //                } else {
                cnt1++;
                //                }
            }
            StringBuilder basesql = new StringBuilder();
            basesql.append(CreateDataConstants.JBPM_PROCESSINSTANCE_INSERT).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.PROCESS_INSTANCE + cnt).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append(1).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append("2016-01-06 11:56:53.000")
            .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
            if (((cnt1 - 1) * (CreateDataConstants.cnt_max / 10) <= cnt) &&
                cnt < (cnt1 - 1) * (CreateDataConstants.cnt_max / 10) + CreateDataConstants.ACTIVEPROCESS_NUM) {
                basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            } else {
                basesql.append(CreateDataConstants.quoat).append("2016-01-21 20:49:01.000")
                .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
            }
            basesql.append(CreateDataConstants.quoat).append(0).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append(temp.get(CreateDataConstants.KEY_PROCESSDEFINITION))
            .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.right)
            .append(CreateDataConstants.semicoron);

            pw.println(basesql.toString());
        }
        pw.close();
        System.out.println("JBPM_PROCESSINSTANCE_INSERT create complete.");

    }

    private static void createUpdateJBPMPROCESSINSTANCESql() throws IOException {
        long cnt = 0;
        File file = new File(CreateDataConstants.filepath + CreateDataConstants.dirpath2
            + CreateDataConstants.filename_JBPM_PROCESSINSTANCE_UPDATE);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));

        Map<String, String> temp = null;

        int cnt1 = 0;
        for (cnt = 0; cnt < CreateDataConstants.cnt_max; cnt++) {
            if (cnt % (CreateDataConstants.cnt_max / 10) == 0) {
                temp = CreateDataConstants.mapList.get(cnt1);
                //                if(cnt1 == CreateDataConstants.mapList.size() - 1){
                //                    cnt1 = 0;
                //                } else {
                cnt1++;
                //                }
            }
            StringBuilder basesql = new StringBuilder();
            basesql.append(CreateDataConstants.JBPM_PROCESSINSTANCE_UPDATE).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.ROOT_TOKEN + cnt).append(CreateDataConstants.quoat);
            basesql.append(CreateDataConstants.JBPM_UPDATE_WHERE);
            basesql.append(CreateDataConstants.quoat).append(CreateDataConstants.PROCESS_INSTANCE + cnt)
            .append(CreateDataConstants.quoat).append(CreateDataConstants.semicoron);

            pw.println(basesql.toString());
        }
        pw.close();
        System.out.println("JBPM_PROCESSINSTANCE_UPDATE create complete.");

    }

    private static void createInsertJBPMTOKENSql() throws IOException {

        long cnt = 0;
        File file = new File(CreateDataConstants.filepath + CreateDataConstants.dirpath1
            + CreateDataConstants.filename_JBPM_TOKEN_INSERT);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));

        Map<String, String> temp = null;

        int cnt1 = 0;
        for (cnt = 0; cnt < CreateDataConstants.cnt_max; cnt++) {
            if (cnt % (CreateDataConstants.cnt_max / 10) == 0) {
                temp = CreateDataConstants.mapList.get(cnt1);
                //                if(cnt1 == CreateDataConstants.mapList.size() - 1){
                //                    cnt1 = 0;
                //                } else {
                cnt1++;
                //                }
            }
            StringBuilder basesql = new StringBuilder();
            basesql.append(CreateDataConstants.JBPM_TOKEN_INSERT).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.ROOT_TOKEN + cnt).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append(1).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append("2016-01-06 11:56:53.000")
            .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
            if (((cnt1 - 1) * (CreateDataConstants.cnt_max / 10) <= cnt) &&
                cnt < (cnt1 - 1) * (CreateDataConstants.cnt_max / 10) + CreateDataConstants.ACTIVEPROCESS_NUM) {
                basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            } else {
                basesql.append(CreateDataConstants.quoat).append("2016-01-21 20:49:01.000")
                .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
            }
            basesql.append(CreateDataConstants.quoat).append("2016-01-06 11:56:53.000")
            .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append(String.valueOf(23 * (cnt + 1)))
            .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);

            if (((cnt1 - 1) * (CreateDataConstants.cnt_max / 10) <= cnt) &&
                cnt < (cnt1 - 1) * (CreateDataConstants.cnt_max / 10) + CreateDataConstants.ACTIVEPROCESS_NUM) {
                basesql.append(CreateDataConstants.quoat).append(1).append(CreateDataConstants.quoat)
                .append(CreateDataConstants.comma);
            } else {
                basesql.append(CreateDataConstants.quoat).append(0).append(CreateDataConstants.quoat)
                .append(CreateDataConstants.comma);
            }

            basesql.append(CreateDataConstants.quoat).append(0).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);

            if (((cnt1 - 1) * (CreateDataConstants.cnt_max / 10) <= cnt) &&
                cnt < (cnt1 - 1) * (CreateDataConstants.cnt_max / 10) + CreateDataConstants.ACTIVEPROCESS_NUM) {
                basesql.append(CreateDataConstants.quoat).append(temp.get(CreateDataConstants.KEY_NODE))
                .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
            } else {
                basesql.append(CreateDataConstants.quoat).append(temp.get(CreateDataConstants.KEY_ENDNODE))
                .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
            }

            basesql.append(CreateDataConstants.quoat).append(0).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str);
            basesql.append(CreateDataConstants.right).append(CreateDataConstants.semicoron);

            pw.println(basesql.toString());
        }
        pw.close();
        System.out.println("JBPM_TOKEN_INSERT create complete.");

    }

    private static void createUpdateJBPMTOKENSql() throws IOException {
        long cnt = 0;
        File file = new File(CreateDataConstants.filepath + CreateDataConstants.dirpath2
            + CreateDataConstants.filename_JBPM_TOKEN_UPDATE);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));

        Map<String, String> temp = null;

        int cnt1 = 0;
        for (cnt = 0; cnt < CreateDataConstants.cnt_max; cnt++) {
            if (cnt % (CreateDataConstants.cnt_max / 10) == 0) {
                temp = CreateDataConstants.mapList.get(cnt1);
                //                if(cnt1 == CreateDataConstants.mapList.size() - 1){
                //                    cnt1 = 0;
                //                } else {
                cnt1++;
                //                }
            }
            StringBuilder basesql = new StringBuilder();
            basesql.append(CreateDataConstants.JBPM_TOKEN_UPDATE).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.PROCESS_INSTANCE + cnt).append(CreateDataConstants.quoat);
            basesql.append(CreateDataConstants.JBPM_UPDATE_WHERE);
            basesql.append(CreateDataConstants.quoat).append(CreateDataConstants.ROOT_TOKEN + cnt)
            .append(CreateDataConstants.quoat).append(CreateDataConstants.semicoron);

            pw.println(basesql.toString());
        }
        pw.close();
        System.out.println("JBPM_TOKEN_UPDATE create complete.");

    }

    private static void createInsertJBPMMODULEINSTANCESql() throws IOException {

        long cnt = 0;
        File file = new File(CreateDataConstants.filepath + CreateDataConstants.dirpath3
            + CreateDataConstants.filename_JBPM_MODULEINSTANCE_INSERT);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));

        Map<String, String> temp = null;

        int cnt1 = 0;
        for (cnt = 0; cnt < CreateDataConstants.cnt_max; cnt++) {
            if (cnt % (CreateDataConstants.cnt_max / 10) == 0) {
                temp = CreateDataConstants.mapList.get(cnt1);
                //                if(cnt1 == CreateDataConstants.mapList.size() - 1){
                //                    cnt1 = 0;
                //                } else {
                cnt1++;
                //                }
            }
            StringBuilder basesql = new StringBuilder();
            basesql.append(CreateDataConstants.JBPM_MODULEINSTANCE_INSERT).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.CONTEXT_INSTANCE + cnt).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append("C").append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append(0).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append(CreateDataConstants.PROCESS_INSTANCE + cnt)
            .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append("org.jbpm.context.exe.ContextInstance")
            .append(CreateDataConstants.quoat);
            basesql.append(CreateDataConstants.right).append(CreateDataConstants.semicoron);

            pw.println(basesql.toString());

            basesql = new StringBuilder();
            basesql.append(CreateDataConstants.JBPM_MODULEINSTANCE_INSERT).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.TASKMNG_INSTANCE + cnt).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append("T").append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append(1).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append(CreateDataConstants.PROCESS_INSTANCE + cnt)
            .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append(temp.get(CreateDataConstants.KEY_TASKMGMTDEFINITION))
            .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append("org.jbpm.taskmgmt.exe.TaskMgmtInstance")
            .append(CreateDataConstants.quoat);
            basesql.append(CreateDataConstants.right).append(CreateDataConstants.semicoron);

            pw.println(basesql.toString());
        }
        pw.close();
        System.out.println("JBPM_MODULEINSTANCE_INSERT create complete.");

    }

    private static void createInsertJBPMTOKENVARIABLEMAPSql() throws IOException {
        long cnt = 0;
        File file = new File(CreateDataConstants.filepath + CreateDataConstants.dirpath3
            + CreateDataConstants.filename_JBPM_TOKENVARIABLEMAP_INSERT);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));

        Map<String, String> temp = null;

        int cnt1 = 0;
        for (cnt = 0; cnt < CreateDataConstants.cnt_max; cnt++) {
            if (cnt % (CreateDataConstants.cnt_max / 10) == 0) {
                temp = CreateDataConstants.mapList.get(cnt1);
                //                if(cnt1 == CreateDataConstants.mapList.size() - 1){
                //                    cnt1 = 0;
                //                } else {
                cnt1++;
                //                }
            }
            StringBuilder basesql = new StringBuilder();
            basesql.append(CreateDataConstants.JBPM_TOKENVARIABLEMAP_INSERT).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.TOKEN_VARIABLE_MAP + cnt).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append(1).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append(CreateDataConstants.ROOT_TOKEN + cnt)
            .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append(CreateDataConstants.CONTEXT_INSTANCE + cnt)
            .append(CreateDataConstants.quoat);
            basesql.append(CreateDataConstants.right).append(CreateDataConstants.semicoron);

            pw.println(basesql.toString());
        }
        pw.close();
        System.out.println("JBPM_TOKENVARIABLEMAP_INSERT create complete.");

    }

    private static void createInsertJBPMTASKINSTANCESql() throws IOException {
        long cnt = 0;
        File file = new File(CreateDataConstants.filepath + CreateDataConstants.dirpath4
            + CreateDataConstants.filename_JBPM_TASKINSTANCE_INSERT);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));

        Map<String, String> temp = null;

        int cnt1 = 0;
        for (cnt = 0; cnt < CreateDataConstants.cnt_max; cnt++) {
            if (cnt % (CreateDataConstants.cnt_max / 10) == 0) {
                temp = CreateDataConstants.mapList.get(cnt1);
                //                if(cnt1 == CreateDataConstants.mapList.size() - 1){
                //                    cnt1 = 0;
                //                } else {
                cnt1++;
                //                }
            }
            StringBuilder basesql = new StringBuilder();
            basesql.append(CreateDataConstants.JBPM_TASKINSTANCE_INSERT).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.TASK_INSTANCE + cnt).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append("T").append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append(1).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append(temp.get(CreateDataConstants.KEY_NAME))
            .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);

            if (((cnt1 - 1) * (CreateDataConstants.cnt_max / 10) <= cnt) &&
                cnt < (cnt1 - 1) * (CreateDataConstants.cnt_max / 10) + CreateDataConstants.ACTIVEPROCESS_NUM) {
                basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            } else {
                basesql.append(CreateDataConstants.quoat).append("administrator").append(CreateDataConstants.quoat)
                .append(CreateDataConstants.comma);
            }

            basesql.append(CreateDataConstants.quoat).append("2016-01-06 11:59:14.000")
            .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);

            if (((cnt1 - 1) * (CreateDataConstants.cnt_max / 10) <= cnt) &&
                cnt < (cnt1 - 1) * (CreateDataConstants.cnt_max / 10) + CreateDataConstants.ACTIVEPROCESS_NUM) {
                basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            } else {
                basesql.append(CreateDataConstants.quoat).append("2016-01-21 20:48:15.000")
                .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
            }

            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append(3).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append(0).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append(0).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);

            if (((cnt1 - 1) * (CreateDataConstants.cnt_max / 10) <= cnt) &&
                cnt < (cnt1 - 1) * (CreateDataConstants.cnt_max / 10) + CreateDataConstants.ACTIVEPROCESS_NUM) {
                basesql.append(CreateDataConstants.quoat).append(1).append(CreateDataConstants.quoat)
                .append(CreateDataConstants.comma);
                basesql.append(CreateDataConstants.quoat).append(1).append(CreateDataConstants.quoat)
                .append(CreateDataConstants.comma);
            } else {
                basesql.append(CreateDataConstants.quoat).append(0).append(CreateDataConstants.quoat)
                .append(CreateDataConstants.comma);
                basesql.append(CreateDataConstants.quoat).append(0).append(CreateDataConstants.quoat)
                .append(CreateDataConstants.comma);
            }

            basesql.append(CreateDataConstants.quoat).append(0).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append(temp.get(CreateDataConstants.KEY_TASK))
            .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append(CreateDataConstants.ROOT_TOKEN + cnt)
            .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append(CreateDataConstants.PROCESS_INSTANCE + cnt)
            .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append(CreateDataConstants.TASKMNG_INSTANCE + cnt)
            .append(CreateDataConstants.quoat);
            basesql.append(CreateDataConstants.right).append(CreateDataConstants.semicoron);

            pw.println(basesql.toString());
        }
        pw.close();
        System.out.println("JBPM_TASKINSTANCE_INSERT create complete.");

    }

    private static void createInsertJBPMVARIABLEINSTANCESql() throws IOException {
        long cnt = 0;
        File file = new File(CreateDataConstants.filepath + CreateDataConstants.dirpath4
            + CreateDataConstants.filename_JBPM_VARIABLEINSTANCE_INSERT);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));

        int cnt1 = 0;
        for (cnt = 0; cnt < CreateDataConstants.cnt_max; cnt++) {
            if (cnt % (CreateDataConstants.cnt_max / 10) == 0) {
                //                if(cnt1 == CreateDataConstants.mapList.size() - 1){
                //                    cnt1 = 0;
                //                } else {
                cnt1++;
                //                }
            }
            StringBuilder basesql = new StringBuilder();
            basesql.append(CreateDataConstants.JBPM_VARIABLEINSTANCE_INSERT).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.VARIABLE_INSTANCE + cnt * 8).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append("S").append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append(0).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append("KOUTEI_KAISIDAY").append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append(CreateDataConstants.ROOT_TOKEN + cnt)
            .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append(CreateDataConstants.TOKEN_VARIABLE_MAP + cnt)
            .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append(CreateDataConstants.PROCESS_INSTANCE + cnt)
            .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append("20160106").append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str);
            basesql.append(CreateDataConstants.right).append(CreateDataConstants.semicoron);

            pw.println(basesql.toString());

            basesql = new StringBuilder();
            basesql.append(CreateDataConstants.JBPM_VARIABLEINSTANCE_INSERT).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.VARIABLE_INSTANCE + cnt * 8 + 1).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append("S").append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append(0).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append("SYORI_STATUS").append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append(CreateDataConstants.ROOT_TOKEN + cnt)
            .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append(CreateDataConstants.TOKEN_VARIABLE_MAP + cnt)
            .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append(CreateDataConstants.PROCESS_INSTANCE + cnt)
            .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append("10").append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str);
            basesql.append(CreateDataConstants.right).append(CreateDataConstants.semicoron);

            pw.println(basesql.toString());

            basesql = new StringBuilder();
            basesql.append(CreateDataConstants.JBPM_VARIABLEINSTANCE_INSERT).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.VARIABLE_INSTANCE + cnt * 8 + 2).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append("S").append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append(1).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append("LOCK_TIME").append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append(CreateDataConstants.ROOT_TOKEN + cnt)
            .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append(CreateDataConstants.TOKEN_VARIABLE_MAP + cnt)
            .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append(CreateDataConstants.PROCESS_INSTANCE + cnt)
            .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str);
            basesql.append(CreateDataConstants.right).append(CreateDataConstants.semicoron);

            pw.println(basesql.toString());

            basesql = new StringBuilder();
            basesql.append(CreateDataConstants.JBPM_VARIABLEINSTANCE_INSERT).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.VARIABLE_INSTANCE + cnt * 8 + 3).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append("S").append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append(1).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append("LOCK").append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append(CreateDataConstants.ROOT_TOKEN + cnt)
            .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append(CreateDataConstants.TOKEN_VARIABLE_MAP + cnt)
            .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append(CreateDataConstants.PROCESS_INSTANCE + cnt)
            .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str);
            basesql.append(CreateDataConstants.right).append(CreateDataConstants.semicoron);

            pw.println(basesql.toString());

            basesql = new StringBuilder();
            basesql.append(CreateDataConstants.JBPM_VARIABLEINSTANCE_INSERT).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.VARIABLE_INSTANCE + cnt * 8 + 4).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append("N").append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append(0).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append("RULE_CONDITIONNAME").append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);

            if (((cnt1 - 1) * (CreateDataConstants.cnt_max / 10) <= cnt) &&
                cnt < (cnt1 - 1) * (CreateDataConstants.cnt_max / 10) + CreateDataConstants.ACTIVEPROCESS_NUM) {
                basesql.append(CreateDataConstants.quoat).append(CreateDataConstants.ROOT_TOKEN + cnt)
                .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
                basesql.append(CreateDataConstants.quoat).append(CreateDataConstants.TOKEN_VARIABLE_MAP + cnt)
                .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
                basesql.append(CreateDataConstants.quoat).append(CreateDataConstants.PROCESS_INSTANCE + cnt)
                .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
            } else {
                basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
                basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
                basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            }

            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str);
            basesql.append(CreateDataConstants.right).append(CreateDataConstants.semicoron);

            pw.println(basesql.toString());

            basesql = new StringBuilder();
            basesql.append(CreateDataConstants.JBPM_VARIABLEINSTANCE_INSERT).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.VARIABLE_INSTANCE + cnt * 8 + 5).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append("N").append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append(0).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append("RULE_SERVICE_URL").append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append(CreateDataConstants.ROOT_TOKEN + cnt)
            .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append(CreateDataConstants.TOKEN_VARIABLE_MAP + cnt)
            .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append(CreateDataConstants.PROCESS_INSTANCE + cnt)
            .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str);
            basesql.append(CreateDataConstants.right).append(CreateDataConstants.semicoron);

            pw.println(basesql.toString());

            basesql = new StringBuilder();
            basesql.append(CreateDataConstants.JBPM_VARIABLEINSTANCE_INSERT).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.VARIABLE_INSTANCE + cnt * 8 + 6).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append("S").append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append(1).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append("REQUEST_ID").append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append(CreateDataConstants.ROOT_TOKEN + cnt)
            .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append(CreateDataConstants.TOKEN_VARIABLE_MAP + cnt)
            .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append(CreateDataConstants.PROCESS_INSTANCE + cnt)
            .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str);
            basesql.append(CreateDataConstants.right).append(CreateDataConstants.semicoron);

            pw.println(basesql.toString());

            basesql = new StringBuilder();
            basesql.append(CreateDataConstants.JBPM_VARIABLEINSTANCE_INSERT).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.VARIABLE_INSTANCE + cnt * 8 + 7).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append("N").append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append(0).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append("RULE_CONDITION").append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);

            if (((cnt1 - 1) * (CreateDataConstants.cnt_max / 10) <= cnt) &&
                cnt < (cnt1 - 1) * (CreateDataConstants.cnt_max / 10) + CreateDataConstants.ACTIVEPROCESS_NUM) {
                basesql.append(CreateDataConstants.quoat).append(CreateDataConstants.ROOT_TOKEN + cnt)
                .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
                basesql.append(CreateDataConstants.quoat).append(CreateDataConstants.TOKEN_VARIABLE_MAP + cnt)
                .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
                basesql.append(CreateDataConstants.quoat).append(CreateDataConstants.PROCESS_INSTANCE + cnt)
                .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
            } else {
                basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
                basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
                basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            }

            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str);
            basesql.append(CreateDataConstants.right).append(CreateDataConstants.semicoron);

            pw.println(basesql.toString());

        }
        pw.close();
        System.out.println("JBPM_VARIABLEINSTANCE_INSERT create complete.");

    }

    private static void createInsertITImageArriveNoticesql() throws IOException {
        long cnt = 0;
        File file = new File(CreateDataConstants.filepath + CreateDataConstants.dirpath4
            + CreateDataConstants.filename_IT_ImageArriveNotice_INSERT);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));

        Map<String, String> temp = null;

        int cnt1 = 0;
        for (cnt = 0; cnt < CreateDataConstants.cnt_max; cnt++) {
            if (cnt % (CreateDataConstants.cnt_max / 10) == 0) {
                temp = CreateDataConstants.mapList.get(cnt1);
                //                if(cnt1 == CreateDataConstants.mapList.size() - 1){
                //                    cnt1 = 0;
                //                } else {
                cnt1++;
                //                }
            }
            StringBuilder basesql = new StringBuilder();
            basesql.append(CreateDataConstants.IT_ImageArriveNotice_INSERT).append(CreateDataConstants.quoat)
            .append("yuyu").append(CreateDataConstants.ARRIVE_KEY + cnt).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append("kk033").append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append(CreateDataConstants.GYOUMU_KEY + cnt)
            .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append(temp.get(CreateDataConstants.KEY_FLOWID))
            .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append("hozen").append(CreateDataConstants.quoat);
            basesql.append(CreateDataConstants.right).append(CreateDataConstants.semicoron);

            pw.println(basesql.toString());
        }
        pw.close();
        System.out.println("IT_ImageArriveNotice_INSERT create complete.");

    }

    private static void createInsertITGyoumuKeysql() throws IOException {
        long cnt = 0;
        File file = new File(CreateDataConstants.filepath + CreateDataConstants.dirpath4
            + CreateDataConstants.filename_IT_GyoumuKey_INSERT);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));

        Map<String, String> temp = null;

        int cnt1 = 0;
        for (cnt = 0; cnt < CreateDataConstants.cnt_max; cnt++) {
            if (cnt % (CreateDataConstants.cnt_max / 10) == 0) {
                temp = CreateDataConstants.mapList.get(cnt1);
                //                if(cnt1 == CreateDataConstants.mapList.size() - 1){
                //                    cnt1 = 0;
                //                } else {
                cnt1++;
                //                }
            }
            StringBuilder basesql = new StringBuilder();
            basesql.append(CreateDataConstants.IT_GyoumuKey_INSERT).append(CreateDataConstants.quoat)
            .append(temp.get(CreateDataConstants.KEY_FLOWID)).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append(CreateDataConstants.GYOUMU_KEY + cnt)
            .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append(CreateDataConstants.ROOT_TOKEN + cnt)
            .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append("20160106115652543").append(CreateDataConstants.quoat);
            basesql.append(CreateDataConstants.right).append(CreateDataConstants.semicoron);

            pw.println(basesql.toString());
        }
        pw.close();
        System.out.println("IT_GyoumuKey_INSERT create complete.");

    }

    private static void createInsertITPDFHozonsql() throws IOException {
        long cnt = 0;
        File file = new File(CreateDataConstants.filepath + CreateDataConstants.dirpath4
            + CreateDataConstants.filename_IT_PDFHozon_INSERT);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));

        Map<String, String> temp = null;

        int cnt1 = 0;
        for (cnt = 0; cnt < CreateDataConstants.cnt_max; cnt++) {
            if (cnt % (CreateDataConstants.cnt_max / 10) == 0) {
                temp = CreateDataConstants.mapList.get(cnt1);
                //                if(cnt1 == CreateDataConstants.mapList.size() - 1){
                //                    cnt1 = 0;
                //                } else {
                cnt1++;
                //                }
            }
            StringBuilder basesql = new StringBuilder();
            basesql.append(CreateDataConstants.IT_PDFHozon_INSERT).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.IMAGE_ID + cnt).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append(CreateDataConstants.PAGE_ID + cnt)
            .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str);
            basesql.append(CreateDataConstants.right).append(CreateDataConstants.semicoron);

            pw.println(basesql.toString());
        }
        pw.close();
        System.out.println("IT_PDFHozon_INSERT create complete.");

    }

    private static void createInsertITPagesql() throws IOException {
        long cnt = 0;
        File file = new File(CreateDataConstants.filepath + CreateDataConstants.dirpath4
            + CreateDataConstants.filename_IT_Page_INSERT);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));

        Map<String, String> temp = null;

        int cnt1 = 0;
        for (cnt = 0; cnt < CreateDataConstants.cnt_max; cnt++) {
            if (cnt % (CreateDataConstants.cnt_max / 10) == 0) {
                temp = CreateDataConstants.mapList.get(cnt1);
                //                if(cnt1 == CreateDataConstants.mapList.size() - 1){
                //                    cnt1 = 0;
                //                } else {
                cnt1++;
                //                }
            }
            StringBuilder basesql = new StringBuilder();
            basesql.append(CreateDataConstants.IT_Page_INSERT).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.IMAGE_ID + cnt).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append("20160106115912127").append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append("0").append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append(CreateDataConstants.PAGE_ID + cnt)
            .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str);
            basesql.append(CreateDataConstants.right).append(CreateDataConstants.semicoron);

            pw.println(basesql.toString());
        }
        pw.close();
        System.out.println("IT_Page_INSERT create complete.");

    }

    private static void createInsertITTorikomiKanrisql() throws IOException {
        long cnt = 0;
        File file = new File(CreateDataConstants.filepath + CreateDataConstants.dirpath4
            + CreateDataConstants.filename_IT_TorikomiKanri_INSERT);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));

        Map<String, String> temp = null;

        int cnt1 = 0;
        for (cnt = 0; cnt < CreateDataConstants.cnt_max; cnt++) {
            if (cnt % (CreateDataConstants.cnt_max / 10) == 0) {
                temp = CreateDataConstants.mapList.get(cnt1);
                //                if(cnt1 == CreateDataConstants.mapList.size() - 1){
                //                    cnt1 = 0;
                //                } else {
                cnt1++;
                //                }
            }
            StringBuilder basesql = new StringBuilder();
            basesql.append(CreateDataConstants.IT_TorikomiKanri_INSERT).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.IMAGE_ID + cnt).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append("kk033").append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append("20160106115911920").append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str);
            basesql.append(CreateDataConstants.right).append(CreateDataConstants.semicoron);

            pw.println(basesql.toString());
        }
        pw.close();
        System.out.println("IT_TorikomiKanri_INSERT create complete.");

    }

    private static void createInsertITTorikomiRelationsql() throws IOException {
        long cnt = 0;
        File file = new File(CreateDataConstants.filepath + CreateDataConstants.dirpath4
            + CreateDataConstants.filename_IT_TorikomiRelation_INSERT);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));

        Map<String, String> temp = null;

        int cnt1 = 0;
        for (cnt = 0; cnt < CreateDataConstants.cnt_max; cnt++) {
            if (cnt % (CreateDataConstants.cnt_max / 10) == 0) {
                temp = CreateDataConstants.mapList.get(cnt1);
                //                if(cnt1 == CreateDataConstants.mapList.size() - 1){
                //                    cnt1 = 0;
                //                } else {
                cnt1++;
                //                }
            }
            StringBuilder basesql = new StringBuilder();
            basesql.append(CreateDataConstants.IT_TorikomiRelation_INSERT).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.IMAGE_ID + cnt).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append(CreateDataConstants.GYOUMU_KEY + cnt)
            .append(CreateDataConstants.quoat);
            basesql.append(CreateDataConstants.right).append(CreateDataConstants.semicoron);

            pw.println(basesql.toString());
        }
        pw.close();
        System.out.println("IT_TorikomiRelation_INSERT create complete.");

    }

    private static void createInsertITKouteiSummarySql() throws IOException {
        long cnt = 0;
        File file = new File(CreateDataConstants.filepath + CreateDataConstants.dirpath4
            + CreateDataConstants.filename_IT_KouteiSummary_INSERT);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));

        Map<String, String> temp = null;

        int cnt1 = 0;
        for (cnt = 0; cnt < CreateDataConstants.cnt_max; cnt++) {
            if (cnt % (CreateDataConstants.cnt_max / 10) == 0) {
                temp = CreateDataConstants.mapList.get(cnt1);
                //                if(cnt1 == CreateDataConstants.mapList.size() - 1){
                //                    cnt1 = 0;
                //                } else {
                cnt1++;
                //                }
            }
            StringBuilder basesql = new StringBuilder();
            basesql.append(CreateDataConstants.IT_KouteiSummary_INSERT).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.GYOUMU_KEY + cnt).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append(temp.get(CreateDataConstants.KEY_FLOWID))
            .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);

            if (((cnt1 - 1) * (CreateDataConstants.cnt_max / 10) <= cnt) &&
                cnt < (cnt1 - 1) * (CreateDataConstants.cnt_max / 10) + CreateDataConstants.ACTIVEPROCESS_NUM) {
                basesql.append(CreateDataConstants.quoat).append("20160106115913058").append(CreateDataConstants.quoat)
                .append(CreateDataConstants.comma);
            } else {
                basesql.append(CreateDataConstants.quoat).append("20160121204900578").append(CreateDataConstants.quoat)
                .append(CreateDataConstants.comma);
            }

            basesql.append(CreateDataConstants.quoat).append("administrator").append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);

            if (((cnt1 - 1) * (CreateDataConstants.cnt_max / 10) <= cnt) &&
                cnt < (cnt1 - 1) * (CreateDataConstants.cnt_max / 10) + CreateDataConstants.ACTIVEPROCESS_NUM) {
                basesql.append(CreateDataConstants.quoat).append("WebServiceUser").append(CreateDataConstants.quoat)
                .append(CreateDataConstants.comma);
                basesql.append(CreateDataConstants.quoat).append("state-syoruitoutyaku")
                .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
            } else {
                basesql.append(CreateDataConstants.quoat).append("administrator").append(CreateDataConstants.quoat)
                .append(CreateDataConstants.comma);
                basesql.append(CreateDataConstants.quoat).append("input").append(CreateDataConstants.quoat)
                .append(CreateDataConstants.comma);
            }

            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);

            if (((cnt1 - 1) * (CreateDataConstants.cnt_max / 10) <= cnt) &&
                cnt < (cnt1 - 1) * (CreateDataConstants.cnt_max / 10) + CreateDataConstants.ACTIVEPROCESS_NUM) {
                basesql.append(CreateDataConstants.quoat).append(temp.get(CreateDataConstants.KEY_NAME))
                .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
            } else {
                basesql.append(CreateDataConstants.quoat).append("end-state1").append(CreateDataConstants.quoat)
                .append(CreateDataConstants.comma);
            }

            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append("20160106").append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);

            if (((cnt1 - 1) * (CreateDataConstants.cnt_max / 10) <= cnt) &&
                cnt < (cnt1 - 1) * (CreateDataConstants.cnt_max / 10) + CreateDataConstants.ACTIVEPROCESS_NUM) {
                basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
                basesql.append(CreateDataConstants.quoat).append("10").append(CreateDataConstants.quoat)
                .append(CreateDataConstants.comma);
            } else {
                basesql.append(CreateDataConstants.quoat).append("20160121").append(CreateDataConstants.quoat)
                .append(CreateDataConstants.comma);
                basesql.append(CreateDataConstants.quoat).append("90").append(CreateDataConstants.quoat)
                .append(CreateDataConstants.comma);
            }

            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);

            if (((cnt1 - 1) * (CreateDataConstants.cnt_max / 10) <= cnt) &&
                cnt < (cnt1 - 1) * (CreateDataConstants.cnt_max / 10) + CreateDataConstants.JIMUYOUCODE_NUM) {
                basesql.append(CreateDataConstants.quoat).append("100").append(CreateDataConstants.quoat)
                .append(CreateDataConstants.comma);
                basesql.append(CreateDataConstants.quoat).append("0").append(CreateDataConstants.quoat)
                .append(CreateDataConstants.comma);
            } else {
                basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
                basesql.append(CreateDataConstants.quoat).append("1").append(CreateDataConstants.quoat)
                .append(CreateDataConstants.comma);
            }

            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append("20160106115912822").append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append(CreateDataConstants.SYONO_UPPER)
            .append(String.format("%06d", CreateDataConstants.SYONO_LOWER + cnt)).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str);
            basesql.append(CreateDataConstants.right).append(CreateDataConstants.semicoron);

            pw.println(basesql.toString());
        }
        pw.close();
        System.out.println("IT_KouteiSummary_INSERT create complete.");

    }

    private static void createInsertITKouteiRirekiSql() throws IOException {
        long cnt = 0;
        File file = new File(CreateDataConstants.filepath + CreateDataConstants.dirpath4
            + CreateDataConstants.filename_IT_KouteiRireki_INSERT);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));

        Map<String, String> temp = null;

        int cnt1 = 0;
        for (cnt = 0; cnt < CreateDataConstants.cnt_max; cnt++) {
            if (cnt % (CreateDataConstants.cnt_max / 10) == 0) {
                temp = CreateDataConstants.mapList.get(cnt1);
                //                if(cnt1 == CreateDataConstants.mapList.size() - 1){
                //                    cnt1 = 0;
                //                } else {
                cnt1++;
                //                }
            }
            StringBuilder basesql = new StringBuilder();
            basesql.append(CreateDataConstants.IT_KouteiRireki_INSERT).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.ROOT_TOKEN + cnt).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append(CreateDataConstants.GYOUMU_KEY + cnt)
            .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append("0").append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append("20160106115652556").append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append(temp.get(CreateDataConstants.KEY_FLOWID))
            .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat)
            .append(temp.get(CreateDataConstants.KEY_RIREKINODEID).split("\\.")[0])
            .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append("state-syoruitoutyaku").append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append("administrator").append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append("08").append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append("工程開始").append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str);
            basesql.append(CreateDataConstants.right).append(CreateDataConstants.semicoron);

            pw.println(basesql.toString());

            basesql = new StringBuilder();
            basesql.append(CreateDataConstants.IT_KouteiRireki_INSERT).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.ROOT_TOKEN + cnt).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append(CreateDataConstants.GYOUMU_KEY + cnt)
            .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append("0").append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append("20160106115912883").append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append(temp.get(CreateDataConstants.KEY_FLOWID))
            .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat)
            .append(temp.get(CreateDataConstants.KEY_RIREKINODEID).split("\\.")[0])
            .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append("state-syoruitoutyaku").append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append("WebServiceUser").append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append("02").append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append("工程情報更新").append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str);
            basesql.append(CreateDataConstants.right).append(CreateDataConstants.semicoron);

            pw.println(basesql.toString());

            basesql = new StringBuilder();
            basesql.append(CreateDataConstants.IT_KouteiRireki_INSERT).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.ROOT_TOKEN + cnt).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append(CreateDataConstants.GYOUMU_KEY + cnt)
            .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append("0").append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append("20160106115912966").append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append(temp.get(CreateDataConstants.KEY_FLOWID))
            .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat)
            .append(temp.get(CreateDataConstants.KEY_RIREKINODEID).split("\\.")[0])
            .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append("state-syoruitoutyaku").append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append("WebServiceUser").append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append("03").append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append("工程遷移 [state-syoruitoutyaku→")
            .append(temp.get(CreateDataConstants.KEY_NAME)).append("]").append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str);
            basesql.append(CreateDataConstants.right).append(CreateDataConstants.semicoron);

            pw.println(basesql.toString());

            basesql = new StringBuilder();
            basesql.append(CreateDataConstants.IT_KouteiRireki_INSERT).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.ROOT_TOKEN + cnt).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append(CreateDataConstants.GYOUMU_KEY + cnt)
            .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append("1").append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append("20160106115652929").append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append(temp.get(CreateDataConstants.KEY_FLOWID))
            .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat)
            .append(temp.get(CreateDataConstants.KEY_RIREKINODEID).split("\\.")[0])
            .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat)
            .append(CreateDataConstants.FLOWNMMAP.get(temp.get(CreateDataConstants.KEY_FLOWID))).append("請求書作成")
            .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append("administrator").append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append("99").append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append("").append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str);
            basesql.append(CreateDataConstants.right).append(CreateDataConstants.semicoron);

            pw.println(basesql.toString());

            basesql = new StringBuilder();
            basesql.append(CreateDataConstants.IT_KouteiRireki_INSERT).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.ROOT_TOKEN + cnt).append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append(CreateDataConstants.GYOUMU_KEY + cnt)
            .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append("1").append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append("20160106115913053").append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append(temp.get(CreateDataConstants.KEY_FLOWID))
            .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat)
            .append(temp.get(CreateDataConstants.KEY_RIREKINODEID).split("\\.")[1])
            .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append("書類到着").append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append("WebServiceUser").append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append("99").append(CreateDataConstants.quoat)
            .append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.quoat).append("請求書＿")
            .append(CreateDataConstants.FLOWNMMAP.get(temp.get(CreateDataConstants.KEY_FLOWID)))
            .append(CreateDataConstants.quoat).append(CreateDataConstants.comma);
            basesql.append(CreateDataConstants.null_str);
            basesql.append(CreateDataConstants.right).append(CreateDataConstants.semicoron);

            pw.println(basesql.toString());

        }
        pw.close();
        System.out.println("IT_KouteiRireki_INSERT create complete.");

    }
}
