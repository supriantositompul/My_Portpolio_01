# [PBO] - Programming - Taks

Pada case ini, diminta untuk mengembangkan beberapa fitur tambahan dalam Academic Simulator. Pada Tugas-tugas sebelumnya anda telah mengembangkan berbagai fitur manajemen data untuk beberapa entitas yang berada di lingkungan akademik, seperti dosen (```lecturer```), mata kuliah (```course```), mahasiswa (```student```), dan rencana studi (```enrollment```). Di akhir eksekusi, solusi anda telah mampu secara otomatis menampilkan seluruh data dari entitas-entitas yang tersimpan.

Dalam menyelesaikan ujian ini, anda diperbolehkan untuk mendefinisikan kelas-kelas lain yang menurut anda diperlukan. Perlu diingat, kelas-kelas tersebut harus dijabarkan juga pada saat presentasi.

## Task 01: Grading (academic.driverDriver1, 40pts)

Pada tugas ini anda diminta untuk mengembangkan sebuah fitur yang memampukan pengguna mengeset nilai (```grade```) yang diperoleh seorang mahasiswa pada suatu mata kuliah. Nilai yang diberikan berupa nilai huruf, yakni ```A```, ```AB```, ```B```, ```BC```, ```C```, ```D```, dan ```E```.

Untuk mengeset nilai, pengguna akan memasukkan sebaris perintah dengan format sebagai berikut.

```bash
enrollment-grade#<course-code>#<student-id>#<academic-year>#<semester>#<grade>
```

Baris masukan terdiri atas 6 segmen yang diseparasi dengan hash sign (```#```). Segmen pertama adalah perintah yang diberikan dan diikuti dengan serangkaian data terkait rencana studi (```enrollment```) dan nilai (```grade```) yang diberikan. Simulator kemudian akan terlebih dahulu mencari rencana studi (```enrollment```) yang sesuai, bila ditemukan maka dilakukan update terhadap nilai dari rencana studi tersebut. Bila tidak, maka perintah diabaikan dan solusi menuju ke perintah berikutnya. Tidak ada keluaran apapun setelah Simulator selesai mengerjakan perintah ini.

Perhatikan contoh berikut.

**Input**

```bash
lecturer-add#0130058501#Parmonangan Rotua Togatorop#PAT#mona.togatorop@del.ac.id#Information Systems
lecturer-add#0114129002#Iustisia Natalia Simbolon#IUS#iustisia.simbolon@del.ac.id#Informatics
lecturer-add#0124108201#Rosni Lumbantoruan#RSL#rosni@del.ac.id#Information Systems
course-add#12S2102#Basisdata#4#C#PAT,IUS,RSL
course-add#12S2102#Basisdata#4#C#IUS
student-add#12S20001#Marcelino Manalu#2020#Information Systems
enrollment-add#12S2102#12S20001#2021/2022#odd
student-add#12S20002#Yoga Sihombing#2020#Information Systems
enrollment-add#12S2102#12S20002#2021/2022#odd
enrollment-grade#12S2102#12S20002#2021/2022#odd#AB
---

```

**Output**

```bash
0130058501|Parmonangan Rotua Togatorop|PAT|mona.togatorop@del.ac.id|Information Systems
0114129002|Iustisia Natalia Simbolon|IUS|iustisia.simbolon@del.ac.id|Informatics
0124108201|Rosni Lumbantoruan|RSL|rosni@del.ac.id|Information Systems
12S2102|Basisdata|4|C|PAT (mona.togatorop@del.ac.id);IUS (iustisia.simbolon@del.ac.id);RSL (rosni@del.ac.id)
12S20001|Marcelino Manalu|2020|Information Systems
12S20002|Yoga Sihombing|2020|Information Systems
12S2102|12S20001|2021/2022|odd|None
12S2102|12S20002|2021/2022|odd|AB

```

## Task 02: Student's GPA (academic.driverDriver1, 60pts)

Tugas ini merupakan kelanjutan dari **Task 01**. Pada tugas ini anda diminta untuk mengembangkan sebuah fitur yang akan menampilkan info lengkap mengenai seorang mahasiswa beserta performa akademiknya. Performa akademik direpresentasikan dalam bentuk Indeks Prestasi Kumulatif (IPK) atau dikenal juga dengan Grade Point Average (GPA). Silakan untuk melihat mekanisme penghitungan IPK pada Buku Pedoman Akademik. IPK ditulis dalam 2 digit nilai presisi.

Untuk menjalankan fitur ini, pengguna akan memberikan sebuah baris masukan dengan format sebagai berikut.

```bash
student-details#<student-id>
```

Baris masukan terdiri atas 2 segmen yang diseparasi dengan hash sign (```#```). Segmen pertama adalah perintah yang diberikan dan diikuti dengan sebuah nomor induk mahasiswa (```student-id```) yang akan ditampilkan detil informasinya. Bila mahasiswa dimaksud belum tersimpan dalam Simulator, maka perintah akan diabaikan dan Simulator meneruskan ke baris masukan berikutnya. Sebaliknya, bila mahasiswa dengan identitas dimaksud tersimpan di dalam Simulator, maka Simulator akan menampilkan detil informasi dari yang bersangkutan beserta performa akademiknya. Berikut adalah format keluarannya.

```bash
<student-id>|<name>|<year>|<study-program>|<gpa>|<total-credit>
```

Perhatikan contoh berikut.

**Input**

```bash
lecturer-add#0130058501#Parmonangan Rotua Togatorop#PAT#mona.togatorop@del.ac.id#Information Systems
lecturer-add#0114129002#Iustisia Natalia Simbolon#IUS#iustisia.simbolon@del.ac.id#Informatics
lecturer-add#0124108201#Rosni Lumbantoruan#RSL#rosni@del.ac.id#Information Systems
course-add#12S2102#Basisdata#4#C#PAT,IUS,RSL
student-add#12S20001#Marcelino Manalu#2020#Information Systems
enrollment-add#12S2102#12S20001#2021/2022#odd
student-add#12S20002#Yoga Sihombing#2020#Information Systems
course-add#12S1101#Dasar Sistem Informasi#2#D#IUS
enrollment-add#12S1101#12S20001#2020/2021#odd
enrollment-add#12S1101#12S20002#2020/2021#odd
enrollment-add#12S2102#12S20002#2021/2022#odd
enrollment-grade#12S1101#12S20001#2020/2021#odd#B
enrollment-grade#12S1101#12S20002#2020/2021#odd#B
enrollment-grade#12S2102#12S20001#2021/2022#odd#B
enrollment-grade#12S2102#12S20002#2021/2022#odd#AB
student-details#12S20001
student-details#12S20002
---

```

**Output**

```bash
12S20001|Marcelino Manalu|2020|Information Systems|3.00|6
12S20002|Yoga Sihombing|2020|Information Systems|3.33|6
0130058501|Parmonangan Rotua Togatorop|PAT|mona.togatorop@del.ac.id|Information Systems
0114129002|Iustisia Natalia Simbolon|IUS|iustisia.simbolon@del.ac.id|Informatics
0124108201|Rosni Lumbantoruan|RSL|rosni@del.ac.id|Information Systems
12S2102|Basisdata|4|C|PAT (mona.togatorop@del.ac.id);IUS (iustisia.simbolon@del.ac.id);RSL (rosni@del.ac.id)
12S1101|Dasar Sistem Informasi|2|D|IUS (iustisia.simbolon@del.ac.id)
12S20001|Marcelino Manalu|2020|Information Systems
12S20002|Yoga Sihombing|2020|Information Systems
12S2102|12S20001|2021/2022|odd|B
12S1101|12S20001|2020/2021|odd|B
12S1101|12S20002|2020/2021|odd|B
12S2102|12S20002|2021/2022|odd|AB

```

## Submission
1. ```src/academic/model/*.java```;
2. ```src/academic/driver/*.java```;
3. changelog.txt

