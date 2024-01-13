package com.example.back_pdf.controller;

import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@CrossOrigin(origins="http://localhost:4200")
@RestController

public class PdfMergeController {

    @PostMapping("/api/merge")
    public ResponseEntity<byte[]> mergePDFs(@RequestParam("files") MultipartFile[] files) {
        try {
            byte[] mergedPdfData = mergePdfFiles(files);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("attachment", "merged.pdf");

            return ResponseEntity.ok()
                    .headers(headers)
                    .body(mergedPdfData);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    private byte[] mergePdfFiles(MultipartFile[] files) throws IOException {
        PDFMergerUtility merger = new PDFMergerUtility();
        ByteArrayOutputStream mergedOutputStream = new ByteArrayOutputStream();

        for (MultipartFile file : files) {
            merger.addSource(file.getInputStream());
        }

        merger.setDestinationStream(mergedOutputStream);
        merger.mergeDocuments();

        return mergedOutputStream.toByteArray();
    }
}
