CREATE VIEW ZT_DsHanyouKokyakuTuutiRn AS SELECT
     zrndshanyoukokatetuutikey ,         /* （連携用）ＤＳ汎用顧客宛通知キー */
     zrndskokno ,         /* （連携用）ＤＳ顧客番号 */
     zrndstuutikbn ,         /* （連携用）ＤＳ通知区分 */
     zrnatesakiyno ,         /* （連携用）宛先郵便番号 */
     zrnatesakiadr1 ,         /* （連携用）宛先住所１ */
     zrnatesakiadr2 ,         /* （連携用）宛先住所２ */
     zrnatesakiadr3 ,         /* （連携用）宛先住所３ */
     zrnatena1 ,         /* （連携用）宛名１ */
     zrnatena2 ,         /* （連携用）宛名２ */
     zrnatesakiynobarcode ,         /* （連携用）宛先郵便番号バーコード */
     zrndai1syoukaifreearea11 ,         /* （連携用）第１照会先フリーエリア１＿１ */
     zrndai1syoukaifreearea12 ,         /* （連携用）第１照会先フリーエリア１＿２ */
     zrndai1syoukaifreearea13 ,         /* （連携用）第１照会先フリーエリア１＿３ */
     zrndai1syoukaifreearea14 ,         /* （連携用）第１照会先フリーエリア１＿４ */
     zrndai1syoukaifreearea15 ,         /* （連携用）第１照会先フリーエリア１＿５ */
     zrnscdai2syoukaifreearea1 ,         /* （連携用）ＳＣ第２照会先フリ－エリア１ */
     zrnscdai2syoukaifreearea2 ,         /* （連携用）ＳＣ第２照会先フリ－エリア２ */
     zrnscdai2syoukaifreearea3 ,         /* （連携用）ＳＣ第２照会先フリ－エリア３ */
     zrnscdai2syoukaifreearea4 ,         /* （連携用）ＳＣ第２照会先フリ－エリア４ */
     zrnscdai2syoukaifreearea5 ,         /* （連携用）ＳＣ第２照会先フリ－エリア５ */
     zrnsakuseimd ,         /* （連携用）作成月日 */
     zrnsclakadskokno ,         /* （連携用）スクランブル化ＤＳ顧客番号 */
     zrnreigaisyorihyj ,         /* （連携用）例外処理表示 */
     zrnsakuseino ,         /* （連携用）作成No */
     zrncode ,         /* （連携用）コード */
     zrntuutimei ,         /* （連携用）通知名 */
     zrnfreearea11 ,         /* （連携用）フリーエリア１＿１ */
     zrnfreearea12 ,         /* （連携用）フリーエリア１＿２ */
     zrnfreearea13 ,         /* （連携用）フリーエリア１＿３ */
     zrnfreearea14 ,         /* （連携用）フリーエリア１＿４ */
     zrnfreearea15 ,         /* （連携用）フリーエリア１＿５ */
     zrnfreearea16 ,         /* （連携用）フリーエリア１＿６ */
     zrnfreearea17 ,         /* （連携用）フリーエリア１＿７ */
     zrnfreearea18 ,         /* （連携用）フリーエリア１＿８ */
     zrnfreearea19 ,         /* （連携用）フリーエリア１＿９ */
     zrnfreearea110 ,         /* （連携用）フリーエリア１＿１０ */
     zrnfreearea111 ,         /* （連携用）フリーエリア１＿１１ */
     zrnfreearea112 ,         /* （連携用）フリーエリア１＿１２ */
     zrnfreearea113 ,         /* （連携用）フリーエリア１＿１３ */
     zrnfreearea114 ,         /* （連携用）フリーエリア１＿１４ */
     zrnfreearea115 ,         /* （連携用）フリーエリア１＿１５ */
     zrnfreearea116 ,         /* （連携用）フリーエリア１＿１６ */
     zrnfreearea117 ,         /* （連携用）フリーエリア１＿１７ */
     zrnfreearea118 ,         /* （連携用）フリーエリア１＿１８ */
     zrnfreearea119 ,         /* （連携用）フリーエリア１＿１９ */
     zrnfreearea120 ,         /* （連携用）フリーエリア１＿２０ */
     zrnfreearea121 ,         /* （連携用）フリーエリア１＿２１ */
     zrnfreearea122 ,         /* （連携用）フリーエリア１＿２２ */
     zrnfreearea123 ,         /* （連携用）フリーエリア１＿２３ */
     zrnfreearea124 ,         /* （連携用）フリーエリア１＿２４ */
     zrnfreearea125 ,         /* （連携用）フリーエリア１＿２５ */
     zrnfreearea126 ,         /* （連携用）フリーエリア１＿２６ */
     zrnfreearea127 ,         /* （連携用）フリーエリア１＿２７ */
     zrnfreearea128 ,         /* （連携用）フリーエリア１＿２８ */
     zrnfreearea21 ,         /* （連携用）フリーエリア２＿１ */
     zrnfreearea22 ,         /* （連携用）フリーエリア２＿２ */
     zrnfreearea23 ,         /* （連携用）フリーエリア２＿３ */
     zrnfreearea24 ,         /* （連携用）フリーエリア２＿４ */
     zrnfreearea25 ,         /* （連携用）フリーエリア２＿５ */
     zrnfreearea26 ,         /* （連携用）フリーエリア２＿６ */
     zrnfreearea27 ,         /* （連携用）フリーエリア２＿７ */
     zrnfreearea28 ,         /* （連携用）フリーエリア２＿８ */
     zrnfreearea29 ,         /* （連携用）フリーエリア２＿９ */
     zrnfreearea210 ,         /* （連携用）フリーエリア２＿１０ */
     zrnfreearea211 ,         /* （連携用）フリーエリア２＿１１ */
     zrnfreearea212 ,         /* （連携用）フリーエリア２＿１２ */
     zrnfreearea213 ,         /* （連携用）フリーエリア２＿１３ */
     zrnfreearea214 ,         /* （連携用）フリーエリア２＿１４ */
     zrnfreearea215 ,         /* （連携用）フリーエリア２＿１５ */
     zrnfreearea216 ,         /* （連携用）フリーエリア２＿１６ */
     zrnfreearea217 ,         /* （連携用）フリーエリア２＿１７ */
     zrnfreearea218 ,         /* （連携用）フリーエリア２＿１８ */
     zrnfreearea219 ,         /* （連携用）フリーエリア２＿１９ */
     zrnfreearea220 ,         /* （連携用）フリーエリア２＿２０ */
     zrnfreearea221 ,         /* （連携用）フリーエリア２＿２１ */
     zrnfreearea222 ,         /* （連携用）フリーエリア２＿２２ */
     zrnfreearea223 ,         /* （連携用）フリーエリア２＿２３ */
     zrnfreearea224 ,         /* （連携用）フリーエリア２＿２４ */
     zrnfreearea225 ,         /* （連携用）フリーエリア２＿２５ */
     zrnfreearea226 ,         /* （連携用）フリーエリア２＿２６ */
     zrnfreearea227 ,         /* （連携用）フリーエリア２＿２７ */
     zrnfreearea228           /* （連携用）フリーエリア２＿２８ */
FROM ZT_DsHanyouKokyakuTuutiRn_Z;