public class PdfFactory implements ExportFactory {
    @Override
    public Export createExport() {
        return new PdfExport();
    }
}
