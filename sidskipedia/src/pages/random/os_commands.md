---
title: Random commands on different OS
layout: ../../layouts/MainLayout.astro
---

## Linux

### Remove .DS_Store files
```
find . -name ".DS_Store" -print -delete
```

### Get & Send files/folders from/to Linux machine
```
Get files/folder from Linux machine:
scp -r sid@10.0.0.1:minecraft-old/ Desktop

Send files/folder to Linux machine:
scp pepenarutorun.png sid@10.0.0.1:~/minecraft-old
```

### How to Format USB using the Terminal [(link)](https://phoenixnap.com/kb/linux-format-usb)

**Step 1: Locate USB Drive**  
Open the terminal and run the following command:
```
df
```
The terminal prints out a list of all mounted partitions and relevant information: used space, available space, used space percentage, and the path.

Locate the USB in the list and find the corresponding device.

**Step 2: Unmount and Format USB Drive**  
Unmount the USB drives before formatting. To do so, run this command:
```
sudo umount {USB_FILESYSTEM}
```
After unmounting, format the USB drive using the preferred file system:
```
FAT32 file system: sudo mkfs.vfat /dev/{NAME_OF_DEVICE}
NTFS file system: sudo mkfs.ntfs /dev/{NAME_OF_DEVICE}
exFAT file system: sudo mkfs.exfat /dev/{NAME_OF_DEVICE}
```

**Step 3: Verify USB Drive Formatting**  
Confirm the formatting process has completed successfully:
```
sudo fsck /dev/{NAME_OF_DEVICE}
```
A USB drive with no files indicates successful formatting.

## Windows

### How do I remove the process currently using a port on localhost in Windows? [(link)](https://stackoverflow.com/questions/39632667/how-do-i-remove-the-process-currently-using-a-port-on-localhost-in-windows)

**Step 1:**  
Open up cmd.exe (note: you may need to run it as an administrator, but this isn't always necessary), then run the below command:

```
netstat -ano | findstr :<PORT>

(Replace <PORT> with the port number you want, but keep the colon)

ps: the last column is the PID (process identifier)
```

**Step 2:**  
Next, run the following command:

```
taskkill /PID <PID> /F
```

<br>

### How to Format a Bootable USB Drive [(link)](https://www.instructables.com/How-to-Format-a-Bootable-USB-Drive/)

This is for when you want to restore back your pen drive to its usual condition.  
This is done by formatting the pen drive via DiskPart by follwoing the steps under:

**Step 1:**  
Open `Run` using the key combination (*Win key + R*).

**Step 2:**  
Type `cmd` to open Command Prompt.

**Step 3:**  
Type `diskpart` and run the pop-up winidow that appears. This opens DiskPart.

**Step 4:**  
Type `list disk`. This will list all the memory storage devices connected to the PC.

**Step 5:**  
Type `select disk 1`. (*usually disk 1 if no other storage devices are connected*).  
The number specifies the drive to be formatted.  
Drive 0 wil be your internal hard disk. Identify and select your disk correctly.

**Step 6:**  
Type `clean`. This wipes data off your pen drive.

**Step 7:**  
Type `create partition primary`. This will format the pen drive as FAT.

**Step 8:**  
Now go to *My Computer* or *This PC*, and format the pen drive by right clicking on it and selecting the format option.