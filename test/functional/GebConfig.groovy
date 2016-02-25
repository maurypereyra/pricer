import org.openqa.selenium.Platform
import org.openqa.selenium.chrome.ChromeDriver

baseNavigatorWaiting = true

atCheckWaiting = true

String chromeDriverVersion = "2.21"

String chromeDriverZipFileName
String chromeDriverExecFileName

if (Platform.current.is(Platform.WINDOWS)) {
    chromeDriverZipFileName = "chromedriver_win32.zip"
    chromeDriverExecFileName = "chromedriver.exe"
} else if (Platform.current.is(Platform.MAC)) {
    chromeDriverZipFileName = "chromedriver_mac32.zip"
    chromeDriverExecFileName = "chromedriver"
} else if (Platform.current.is(Platform.LINUX)) {
    chromeDriverZipFileName = "chromedriver_linux32.zip"
    chromeDriverExecFileName = "chromedriver"
} else {
    throw new RuntimeException("Unsupported operating system [${Platform.current}]")
}

String chromeDriverDownloadFullPath = "http://chromedriver.storage.googleapis.com/${chromeDriverVersion}/${chromeDriverZipFileName}"

File chromeDriverLocalFile = downloadDriver(chromeDriverDownloadFullPath, chromeDriverExecFileName, 'zip')

System.setProperty('webdriver.chrome.driver', chromeDriverLocalFile.absolutePath)
driver = { new ChromeDriver() }

private File downloadDriver(String driverDownloadFullPath, String driverFilePath, String archiveFileExtension) {
    File destinationDirectory = new File("target/drivers")
    if (!destinationDirectory.exists()) {
        destinationDirectory.mkdirs()
    }

    File driverFile = new File("${destinationDirectory.absolutePath}/${driverFilePath}")

    String localArchivePath = "target/driver.${archiveFileExtension}"

    if (!driverFile.exists()) {
        def ant = new AntBuilder()
        ant.get(src: driverDownloadFullPath, dest: localArchivePath)

        if (archiveFileExtension == "zip") {
            ant.unzip(src: localArchivePath, dest: destinationDirectory)
        } else {
            ant.untar(src: localArchivePath, dest: destinationDirectory, compression: 'bzip2')
        }

        ant.delete(file: localArchivePath)
        ant.chmod(file: driverFile, perm: '700')
    }

    return driverFile
}